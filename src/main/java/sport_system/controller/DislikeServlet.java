package sport_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport_system.model.FavoriteBean;
import sport_system.model.FavoriteDAO;
import sport_system.model.FavoriteHibernate;


@WebServlet("/sport_system/DislikeServlet")
public class DislikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--DislikeServlet--");
		request.setCharacterEncoding("UTF-8");
		//---delete
		int no = 0;
		String memberId = request.getParameter("memberId").trim();
		int sportId = Integer.parseInt(request.getParameter("sportId").trim());
		
		FavoriteDAO dao = new FavoriteHibernate();
		List<FavoriteBean> favoriteList = dao.getThisAlls(sportId);
		for(FavoriteBean item : favoriteList) {
			if(item.getMemberId().equals(memberId)) {
				no = item.getNo();
				break;
			}
		}
		
		FavoriteBean dislike = new FavoriteBean(no, memberId, sportId);
		dao.delete(dislike);	
	}

}
