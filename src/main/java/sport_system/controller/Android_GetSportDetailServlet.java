package sport_system.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import member_system.model.MemberBean;
import sport_system.model.SportBean;
import sport_system.model.SportHibernate;


@WebServlet("/sport_system/GetSportDetailServlet")
public class Android_GetSportDetailServlet extends HttpServlet {
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
		sport.setPICTURE(null);
		String jsonOut = new Gson().toJson(sport);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonOut);
	}

}
