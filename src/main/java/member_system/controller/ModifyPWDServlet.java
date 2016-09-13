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

@WebServlet("/member_system/ModifyPWDServlet")
public class ModifyPWDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DataBean dataInput = ReadService.readModifyPWD(request);
		MemberBean member = (MemberBean) session.getAttribute("Login");
		Map<String, String> error = dataInput.getError();
		
		if(!error.isEmpty()) {
			// 輸入資料錯誤
			request.setAttribute("errorMsg", error);
			RequestDispatcher rd = request.getRequestDispatcher("modify_password.jsp");
			rd.forward(request, response);
		} else {
			// 更換新密碼,寫入資料庫
			member.setPassword(dataInput.getNewPassword());
			new MemberDAO().updatePwd(member);
			// 修改會員密碼成功
			RequestDispatcher rd = request.getRequestDispatcher("modify_pwd_success.jsp");
			rd.forward(request, response);
		}	
	}

}
