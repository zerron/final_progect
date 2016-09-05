package member_system.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member_system.model.DataBean;
import member_system.model.MemberBean;
import member_system.model.MemberDAO;
import member_system.model.ReadService;

/**
 * Servlet implementation class ModifyInfoServlet
 */
@WebServlet("/member_system/ModifyInfoServlet")
public class ModifyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DataBean dataInput = ReadService.readModifyData(request);
		MemberBean modifyMember = dataInput.getMember();
		Map<String, String> error = dataInput.getError();
		
		// 取得目前登入狀態中的會員帳號
		modifyMember.setMemberId(((MemberBean)session.getAttribute("Login")).getMemberId());
		
		if(!error.isEmpty()) {
			// 輸入資料錯誤
			request.setAttribute("member", modifyMember);
			request.setAttribute("errorMsg", error);
			RequestDispatcher rd = request.getRequestDispatcher("ModifyInfo.jsp");
			rd.forward(request, response);
		} else {
			// 修改會員資料成功
			new MemberDAO().updateInfor(modifyMember);
			request.setAttribute("member", modifyMember);
			RequestDispatcher rd = request.getRequestDispatcher("ModifyInfoSuccess.jsp");
			rd.forward(request, response);
		}	
	}

}
