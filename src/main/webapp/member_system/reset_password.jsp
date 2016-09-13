<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/style_member.css' />" rel="stylesheet" type="text/css">
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script>
	$(document).ready(function(){
		if('${errorMsg}' == ''){
			$(errorText).attr("class","noError");
		}		
	});
</script>
<title>Reset Password</title>
</head>
<body id="page">
	
	<div id="resetTable">
		<div id="logo">
		</div>
		<form Action="<c:url value='ResetPasswordServlet' />" method="POST">

			<H1 id="title">Reset your password</H1>
			
			<div id="errorText" class="inputTable">
				<small><font>${errorMsg.error_memID}</font></small>
				<small><font>${errorMsg.error_memEMAIL}</font></small>
			</div>

			<div class="inputTable">
				<div id="direction">
					請輸入您的帳號和與帳號註冊時相對應的Email，系統將自動寄送新密碼至指定Email
				</div>
				<label for="memID">帳號： </label>
				<input id="memID" class="inputBox" type="text" name="memID" size="10">
				
				<label for="memEMAIL">Email： </label>
				<input id="memEMAIL" class="inputBox" type="text" name="memEMAIL" size="10">
				 
				<input id="subnitBottun" type="submit" value="Send new password email">
			</div>
		</form>
	</div>
	<div id="linkBar">
		<a href="<c:url value='/home.jsp'/>" class="bottomLink">Home</a>
	</div>
</body>
</html>