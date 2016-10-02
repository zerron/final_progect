package sport_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member_system.model.MemberBean;
import sport_system.model.FavoriteBean;
import sport_system.model.FavoriteHibernate;
import sport_system.model.SportBean;
import sport_system.model.SportHibernate;

/**
 * Servlet implementation class GetSportDetailServlet
 */
@WebServlet("/sport_system/GetDetailServlet")
public class GetDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String quertStr = request.getQueryString().trim();
		int id = Integer.parseInt(quertStr.substring(3));
		SportBean itemDetail = new SportHibernate().getSport(id);
		boolean favorite = false;
		
		HttpSession session = request.getSession();
		MemberBean member = (MemberBean) session.getAttribute("Login");
		if(member != null) {
			String memberId = member.getMemberId();
			List<FavoriteBean> favoriteList = new FavoriteHibernate().getThisAlls(id);
			for(FavoriteBean item : favoriteList) {
				if(item.getMemberId().equals(memberId)) {
					favorite = true;
					break;
				}
			}
		}
		
		request.setAttribute("itemDetail", itemDetail);
		request.setAttribute("favorite", favorite);
		RequestDispatcher rd = request.getRequestDispatcher("sport_detail.jsp");
		rd.forward(request, response);
	}

}
