<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員密碼重置</title>
</head>

<body onload="javascript:document.resetPasswordForm.mId.focus();">
	<center>
		<form name="resetPasswordForm" action="<c:url value='ResetPasswordServlet' />" method="POST">
			<table border="1">
				<thead>
					<tr bgcolor='tan'>
						<th height="60" colspan="2" align="center">密碼重置</th>
					</tr>
				</thead>
				<tbody>
					<tr bgcolor='tan'>
						<td width="120" height="40">帳號:</td>
						<td width="600" height="40" align="left"><input id='memID'
							style="text-align: left" name="memID" type="text" size="14"> ${errorMsg.error_memID}
							</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">電子郵件:</td>
						<td width="600" height="40" align="left"><input
							name="memEMAIL" type="text" size="20">${errorMsg.error_memEMAIL}</td> 
					</tr>
					<tr bgcolor='tan'>
						<td height="50" colspan="2" align="center"><input
							type="submit" value="送出"> <input type="reset"
							name="cancel" id="cancel" value="重填"></td>
					</tr>

				</tbody>
			</table>
		</form>
	</center>
</body>
</html>