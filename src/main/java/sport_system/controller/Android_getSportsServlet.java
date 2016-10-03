package sport_system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import sport_system.model.SportBean;
import sport_system.model.SportHibernate;


@WebServlet("/sport_system/GetSportsServlet")
public class Android_getSportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		List<SportBean> sports = new ArrayList();
		try {
			 List<SportBean> result = new SportHibernate().getAllSports();
			 for(SportBean sport : result) {
				 SportBean s = new SportBean();
				 s.setID(sport.getID());
				 s.setSPORTNAME(sport.getSPORTNAME());
				 s.setLAT(sport.getLAT());
				 s.setLNG(sport.getLNG());
				 sports.add(s);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JsonObject jsonOut = new JsonObject();
		jsonOut.add("sports", new Gson().toJsonTree(sports));
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonOut.toString());
	}

}
