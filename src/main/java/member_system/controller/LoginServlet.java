package member_system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import member_system.model.CheckService;
import member_system.model.DataBean;
import member_system.model.MemberBean;
import member_system.model.MemberDAO;
import member_system.model.ReadService;

@WebServlet("/member_system/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberBean logInMember = ReadService.readLogIn(request);
		DataBean checkData = CheckService.memberIsExist(logInMember);
		MemberBean resultMember = checkData.getMember();
		Map<String, String> error = checkData.getError();
		
		// 檢查帳號 --> 檢查密碼
		if(resultMember == null) {
			error.put("error_memID", "此為無效帳號");
		} else if(!logInMember.getPassword().equals(resultMember.getPassword())) {
			error.put("error_memPWD", "密碼輸入錯誤");
		}			
		
		if(!error.isEmpty()) {
			// 登入失敗,顯示錯誤訊息
			request.setAttribute("errorMsg", error);
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		} else {
			// 登入成功,儲存登入狀態
			session.setAttribute("Login", resultMember);
			PrintWriter out = response.getWriter();
//			顯示alert視窗,重新請求轉頁到location
//			out.println("<script>");
//			out.println("alert('Login success. Return Home.');");
//			out.println("location='/final_project/index.jsp';");
//			out.println("</script>");
			
			// 轉頁到原來保留的上一頁
			Object path = session.getAttribute("target");
			if(path != null) {
				response.sendRedirect(path.toString());
			} else {
				response.sendRedirect("/final_project/index.jsp");
			}
			
			
			
		}
		
	}

}
