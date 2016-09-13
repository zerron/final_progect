package member_system.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member_system.model.CheckService;
import member_system.model.CodingService;
import member_system.model.DataBean;
import member_system.model.JavaMailUtil;
import member_system.model.MemberBean;
import member_system.model.MemberDAO;
import member_system.model.ReadService;

/**
 * Servlet implementation class ResetPWDServlet
 */
@WebServlet("/member_system/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBean dataInput = ReadService.readResetCode(request);
		MemberBean member = dataInput.getMember();
		Map<String, String> error = dataInput.getError();
		
		DataBean checkData = CheckService.memberIsExist(member);
		MemberBean checkMember = checkData.getMember();
		
		if(checkMember == null) {
			// 帳號輸入錯誤
			error.put("error_memID", "此為無效帳號");
		} else if (member.getEmail() != null && !member.getEmail().equals(checkMember.getEmail())){
			// Email與會員資料紀錄不符
			System.out.println(member.getEmail());
			System.out.println(checkMember.getEmail());
			error.put("error_memEMAIL", "帳號與Email不相符");
		}
		
		if(!error.isEmpty()) {
			// 輸入資料錯誤
			request.setAttribute("errorMsg", error);
			RequestDispatcher rd = request.getRequestDispatcher("reset_password.jsp");
			rd.forward(request, response);
		} else {
			// 
			String code = CodingService.garbledCode();
			System.out.println(code);
			System.out.println(CodingService.encryptString(code));
			member.setPassword(CodingService.encryptString(code));
			sendMail(member.getEmail(), code);
			new MemberDAO().updatePwd(member);
			RequestDispatcher rd = request.getRequestDispatcher("reset_success.jsp");
			rd.forward(request, response);
		}	
	}
	
	// EMAIL通知使用者重置後的隨機密碼
	public void sendMail(String email, String code) {
		String from = "jerr0987@yahoo.com.tw";
		List<String> to = Arrays.asList(new String[] { email });
		List<String> cc = Arrays.asList(new String[] {});
		List<String> bcc = Arrays.asList(new String[] {});
		String subject = "會員密碼重置";
		String text = "<h1>您的會員密碼已重置為 " + code + "</h1>" + "<h2>您可以按下列連結感受最新的體驗</h2>" + "<a href='http://192.168.11.4:8080/final_project/home .jsp'>首頁</a><br>"
				+ "<br><br><font color='blue'> 再次感謝, </font><br>工作小組敬上";
		JavaMailUtil util = new JavaMailUtil(from, to, cc, bcc, subject, text, null);
		if (util.send()) {
			System.out.println("發信成功");
		} else {
			System.out.println("發信失敗");
		}
	}	

}
