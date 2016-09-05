package member_system.model;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ReadService {
	private static final String ERRORMSG = "請填寫此欄位";
	private static final String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
	
	public static DataBean readMemberData(ServletRequest request) {
		MemberBean member = new MemberBean();
		Map<String,String> error = new HashMap<>();
		DataBean inputData = new DataBean(member, error);
		try {
			request.setCharacterEncoding("UTF-8");
			// 帳號
			String memID = request.getParameter("memID").trim();
			if(memID == null || memID.length() == 0) {
				error.put("error_memID", ERRORMSG);
			} else {
				member.setMemberId(memID);
			}
			// 密碼
			String memPWD = request.getParameter("memPWD").trim();
			if(memPWD == null || memPWD.length() == 0) {
				error.put("error_memPWD", ERRORMSG);
			} else {
				// 密碼加密
				String code = CodingService.encryptString(memPWD);
				member.setPassword(code);
			}
			// 密碼確認
			String checkPWD = request.getParameter("checkPWD").trim();
			if(checkPWD == null || checkPWD.length() == 0) {
				error.put("error_checkPWD", ERRORMSG);
			} else if(!checkPWD.equals(memPWD)) {
				error.put("error_checkPWD", "密碼確認不一致");
			}
			// 姓名
			String memNAME = request.getParameter("memNAME").trim();
			if(memNAME == null || memNAME.length() == 0) {
				error.put("error_memNAME", ERRORMSG);
			} else {
				member.setName(memNAME);
			}
			// 手機
			String memPHN = request.getParameter("memPHN").trim();
			if(memPHN == null || memPHN.length() == 0) {
				error.put("error_memPHN", ERRORMSG);
			} else {
				member.setPhone(memPHN);
			}
			// E-mail
			String memEMAIL = request.getParameter("memEMAIL").trim();
			if(memEMAIL == null || memEMAIL.length() == 0) {
				error.put("error_memEMAIL", ERRORMSG);
			} else if(!memEMAIL.matches(EMAIL_REGEX)){
				error.put("error_memEMAIL", "E-mail格式不符合");
			} else {
				member.setEmail(memEMAIL);
			}
			// 性別
			member.setGender(Integer.parseInt(request.getParameter("memGEN").trim()));
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR_ReadService]: " + e.getMessage());
		}
		
		return inputData;
	}

	public static MemberBean readLogIn(ServletRequest request) {
		MemberBean member = new MemberBean();
		try {
			request.setCharacterEncoding("UTF-8");
			String memID = request.getParameter("memID").trim();
			member.setMemberId(memID);
			String memPWD = request.getParameter("memPWD").trim();
			String code = CodingService.encryptString(memPWD);
			member.setPassword(code);
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR_ReadService]: " + e.getMessage());
		}
		
		return member;
	}
	
	public static DataBean readModifyData(ServletRequest request) {
		MemberBean member = new MemberBean();
		Map<String,String> error = new HashMap<>();
		DataBean inputData = new DataBean(member, error);
		try {
			request.setCharacterEncoding("UTF-8");
			// 姓名
			String memNAME = request.getParameter("memNAME").trim();
			if(memNAME == null || memNAME.length() == 0) {
				error.put("error_memNAME", ERRORMSG);
			} else {
				member.setName(memNAME);
			}
			// 手機
			String memPHN = request.getParameter("memPHN").trim();
			if(memPHN == null || memPHN.length() == 0) {
				error.put("error_memPHN", ERRORMSG);
			} else {
				member.setPhone(memPHN);
			}
			// E-mail
			String memEMAIL = request.getParameter("memEMAIL").trim();
			if(memEMAIL == null || memEMAIL.length() == 0) {
				error.put("error_memEMAIL", ERRORMSG);
			} else if(!memEMAIL.matches(EMAIL_REGEX)){
				error.put("error_memEMAIL", "E-mail格式不符合");
			} else {
				member.setEmail(memEMAIL);
			}
			// 性別
			member.setGender(Integer.parseInt(request.getParameter("memGEN").trim()));
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR_ReadService]: " + e.getMessage());
		}
		
		return inputData;
	}

	public static DataBean readModifyPWD(ServletRequest request) {
		Map<String,String> error = new HashMap<>();
		DataBean inputData = new DataBean(error);
		try {
			request.setCharacterEncoding("UTF-8");
			// 舊密碼
			String memPWD = request.getParameter("memPWD").trim();
			String oldCode = CodingService.encryptString(memPWD);
			// 登入狀態的密碼
			HttpSession session = ((HttpServletRequest)request).getSession();
			String loginPWD = ((MemberBean)session.getAttribute("Login")).getPassword();
			if(memPWD == null || memPWD.length() == 0) {
				error.put("error_memPWD", ERRORMSG);
			} else if (!oldCode.equals(loginPWD)) {
				error.put("error_memPWD", "密碼輸入錯誤");
			} else {
				inputData.setOldPassword(oldCode);
			}
			// 新密碼
			String newPWD = request.getParameter("newPWD").trim();
			if(newPWD == null || newPWD.length() == 0) {
				error.put("error_newPWD", ERRORMSG);
			} else if(newPWD.equals(memPWD)) {
				error.put("error_newPWD", "新密碼不可與舊密碼相同");
			} else {
				// 密碼加密
				String newCode = CodingService.encryptString(newPWD);
				inputData.setNewPassword(newCode);
			}
			// 新密碼確認
			String checkPWD = request.getParameter("checkPWD").trim();
			if(checkPWD == null || checkPWD.length() == 0) {
				error.put("error_checkPWD", ERRORMSG);
			} else if(!checkPWD.equals(newPWD)) {
				error.put("error_checkPWD", "密碼確認不一致");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR_ReadService]: " + e.getMessage());
		}
		
		return inputData;
		
	}

	public static DataBean readResetCode(ServletRequest request) {
		MemberBean member = new MemberBean();
		Map<String,String> error = new HashMap<>();
		DataBean inputData = new DataBean(member, error);
		try {
			request.setCharacterEncoding("UTF-8");
			// 帳號
			String memID = request.getParameter("memID").trim();
			if(memID == null || memID.length() == 0) {
				error.put("error_memID", ERRORMSG);
			} else {
				member.setMemberId(memID);
			}
			// E-mail
			String memEMAIL = request.getParameter("memEMAIL").trim();
			if(memEMAIL == null || memEMAIL.length() == 0) {
				error.put("error_memEMAIL", ERRORMSG);
			} else if(!memEMAIL.matches(EMAIL_REGEX)){
				error.put("error_memEMAIL", "E-mail格式不符合");
			} else {
				member.setEmail(memEMAIL);
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR_ReadService]: " + e.getMessage());
		}
		
		return inputData;
	}

}
