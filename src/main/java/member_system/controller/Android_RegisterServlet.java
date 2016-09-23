package member_system.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import member_system.model.CheckService;
import member_system.model.CodingService;
import member_system.model.JavaMailUtil;
import member_system.model.MemberBean;
import member_system.model.MemberDAO;

@WebServlet("/Android/RegisterServlet")
public class Android_RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 讀取Android端輸入的會員註冊資料
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}
		MemberBean register = new Gson().fromJson(jsonIn.toString(), MemberBean.class);
		// 檢查會員註冊資料
		JsonObject jsonOut = new JsonObject();
		// 會員帳號是否重複
		Map<String, String> error = CheckService.memberIsExist(register).getError();
		if(error.isEmpty()) {
			// 會員密碼加密
			register.setPassword(CodingService.encryptString(register.getPassword().trim()));
			// insert會員註冊資料至Database
			new MemberDAO().insert(register);
			sendMail(register.getEmail(), register);
			
			String success = null;
			jsonOut.addProperty("errorMsg", success);
		} else {
			jsonOut.addProperty("errorMsg", "帳號重複");
		}
		// 傳回檢查結果
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonOut.toString());
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
