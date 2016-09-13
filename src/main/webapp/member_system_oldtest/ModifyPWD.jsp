<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改會員</title>
</head>

<body onload="javascript:document.modifyMemberForm.memNAME.focus();">
	<center>
		<form name="modifyMemberForm" action="<c:url value='ModifyPWDServlet' />" method="POST">
			<table border="1">
				<thead>
					<tr bgcolor='tan'>
						<th height="60" colspan="2" align="center">修改會員資料</th>
					</tr>
				</thead>
				<tbody>
					<tr bgcolor='tan'>
						<td width="120" height="40">舊密碼:</td>
						<td width="600" height="40" align="left"><input id='memPWD'
							style="text-align: left" name="memPWD" type="password" size="14"> ${errorMsg.error_memPWD}
						</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">新密碼:</td>
						<td width="600" height="40" align="left"><input id='newPWD'
							style="text-align: left" name="newPWD" type="password" size="14"> ${errorMsg.error_newPWD}
						</td>
					</tr>
					<tr bgcolor='tan'>
						<td width="120" height="40">新密碼確認:</td>
						<td width="600" height="40" align="left"><input
							id='checkPWD' style="text-align: left" name="checkPWD"
							type="password" size="14">${errorMsg.error_checkPWD}</td> 
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