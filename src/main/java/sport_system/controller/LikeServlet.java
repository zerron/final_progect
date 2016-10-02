package sport_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport_system.model.FavoriteBean;
import sport_system.model.FavoriteDAO;
import sport_system.model.FavoriteHibernate;


@WebServlet("/sport_system/LikeServlet")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--LikeServlet--");
		request.setCharacterEncoding("UTF-8");
		//---insert
		String memberId = request.getParameter("memberId").trim();
		int sportId = Integer.parseInt(request.getParameter("sportId").trim());
		FavoriteBean like = new FavoriteBean(3,memberId, sportId);
		
		FavoriteDAO dao = new FavoriteHibernate();
		dao.save(like);	
	}

}
