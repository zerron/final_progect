<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='https://www.google.com/recaptcha/api.js'></script>
<title>加入會員</title>
</head>

<body onload="javascript:document.insertMemberFormA.mId.focus();">
	<center>
		<form name="insertMemberFormA"
			action="<c:url value='RegisterServlet' />" method="POST">
			<table border="1">
				<thead>
					<tr bgcolor='tan'>
						<th height="60" colspan="2" align="center">新增會員資料</th>
					</tr>
				</thead>
				<tbody>
					<tr bgcolor='tan'>
						<td width="120" height="40">帳號:</td>
						<td width="600" height="40" align="left"><input id='memID'
							style="text-align: left" name="memID" type="text" size="14"
							value="${member.memberId}"> ${errorMsg.error_memID}</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">密碼:</td>
						<td width="600" height="40" align="left"><input id='memPWD'
							style="text-align: left" name="memPWD" type="password" size="14">
							${errorMsg.error_memPWD}</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">密碼確認:</td>
						<td width="600" height="40" align="left"><input id='checkPWD'
							style="text-align: left" name="checkPWD" type="password"
							size="14">${errorMsg.error_checkPWD}</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">姓名:</td>
						<td width="600" height="40" align="left"><input name=memNAME
							type="text" size="20" value="${member.name}">${errorMsg.error_memNAME}</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">手機:</td>
						<td width="600" height="40" align="left"><input name="memPHN"
							type="text" size="20" value="${member.phone}">${errorMsg.error_memPHN}</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">電子郵件:</td>
						<td width="600" height="40" align="left"><input
							name="memEMAIL" type="text" size="20" value="${member.email}">${errorMsg.error_memEMAIL}</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">性別:</td>
						<td width="600" height="40" align="left"><input name="memGEN"
							type="radio" value="1" size="20" checked>男 <input
							name="memGEN" type="radio" value="2" size="20">女</td>
					</tr>
					<tr bgcolor='tan'>
						<td height="50" colspan="2" align="center">
						<div class="g-recaptcha"
								data-sitekey="6LdQKCkTAAAAAEO9wlotv41Z74mNE_lQJ7zqQbRN">${errorMsg.error_reCAPTCHA}</div>
						<input
							type="submit" value="送出"> <input type="reset"
							name="cancel" id="cancel" value="重填"></td>
					</tr>

				</tbody>
			</table>
		</form>
	</center>
</body>
</html>