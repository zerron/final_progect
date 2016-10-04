package sport_system.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import sport_system.model.SportBean;
import sport_system.model.SportHibernate;


@WebServlet("/sport_system/GetSportImageServlet")
public class Android_GetSportImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BufferedReader br = request.getReader();
		StringBuilder jsonStr = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonStr.append(line);
		}
		JsonObject jsonIn = new Gson().fromJson(jsonStr.toString(), JsonObject.class);
		int id = jsonIn.get("id").getAsInt();
		SportBean sport = new SportHibernate().getSport(id);
		
		try {
			InputStream is = sport.getPICTURE().getBinaryStream();
			String mimeType = getServletContext().getMimeType(sport.getBlobFileName());
			response.setContentType(mimeType);
			OutputStream out = response.getOutputStream();
			int len = 0 ; 
			byte[] b = new byte[is.available()];
			while ( ( len = is.read(b) )!= -1){
				out.write(b, 0, len);
			}
			is.close();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
