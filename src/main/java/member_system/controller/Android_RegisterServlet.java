package member_system.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
			
			jsonOut.addProperty("errorMsg", "會員註冊成功");
		} else {
			jsonOut.addProperty("errorMsg", "帳號重複");
		}
		// 傳回檢查結果
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonOut.toString());
	}

}
