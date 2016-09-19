package member_system.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import member_system.model.CodingService;
import member_system.model.MemberBean;
import member_system.model.MemberDAO;

@WebServlet("/Android/LoginServlet")
public class Android_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 讀取Android端輸入的會員帳號密碼
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}
		MemberBean logInMember = new Gson().fromJson(jsonIn.toString(), MemberBean.class);
		String code = CodingService.encryptString(logInMember.getPassword().trim());
		// 查詢Database內對應的會員資料
		MemberBean resultMember = new MemberDAO().selectByMemberid(logInMember.getMemberId());
		// 會員帳號密碼檢查
		String error = "有效帳號";
		if(resultMember == null) {
			error = "此為無效帳號";
		} else if(!code.equals(resultMember.getPassword())) {
			error = "密碼輸入錯誤";
		}
		// 傳回檢查結果
		JsonObject jsonOut = new JsonObject();
		jsonOut.addProperty("errorMsg", error);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonOut.toString());
		
	}

}
