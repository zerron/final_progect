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
import member_system.model.VerifyUtils;

@WebServlet("/member_system/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 讀取前端網頁的註冊會員資料
		DataBean dataInput = ReadService.readMemberData(request);
		MemberBean member = dataInput.getMember();
		Map<String, String> error = dataInput.getError();
		// 檢查會員帳號是否重複
		DataBean checkData = CheckService.memberIsExist(member);
		error.putAll(checkData.getError());
		
		// reCAPTCHA驗證
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);
		boolean valid = VerifyUtils.verify(gRecaptchaResponse);
		System.out.println(valid);
		if(valid == false)
			error.put("error_reCAPTCHA", "驗證錯誤");
		
		if(!error.isEmpty()) {
			// 輸入資料錯誤
			request.setAttribute("member", member);
			request.setAttribute("errorMsg", error);
			RequestDispatcher rd = request.getRequestDispatcher("sign_up.jsp");
			rd.forward(request, response);
		} else {
			// 註冊成功
			new MemberDAO().insert(member);
			sendMail(member.getEmail(), member);
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("sign_up_success.jsp");
			rd.forward(request, response);
		}	
	}
	
	
	
	// EMAIL通知--------------驗證機制尚未建立
	public void sendMail(String email, MemberBean member) {
		String from = "jerr098765@gmail.com";
		String fromName = "GUEMI Member System";
		List<String> to = Arrays.asList(new String[] { email });
		List<String> cc = Arrays.asList(new String[] {});
		List<String> bcc = Arrays.asList(new String[] {});
		String subject = "歡迎加入規秘會員";
		String pwd = CodingService.decryptString(CodingService.KEY, member.getPassword());
		String code = "";
		for(int i = 0; i < pwd.length()-2; i++){
			code += "*";
		}
		String text = "<h1>謝謝您加入規秘會員</h1>"
					+ "<h4>會員帳號: " + member.getMemberId() + "</h4>"
					+ "<h4>會員密碼: " + pwd.substring(0, 2) + code + "</h4>"
					+ "<h2>您可以按下列連結感受最新的體驗</h2>" 
					+ "<a href='http://192.168.11.4:8080/final_project/home.jsp'>首頁</a><br>"
					+ "<br><br><font color='blue'> 再次感謝, </font><br>工作小組敬上";
		JavaMailUtil util = new JavaMailUtil(from, fromName, to, cc, bcc, subject, text, null);
		if (util.send()) {
			System.out.println("發信成功");
		} else {
			System.out.println("發信失敗");
		}
	}
}

