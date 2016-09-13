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
<title>Sign In</title>
</head>
<body id="page">
	
	<div id="signInTable">
		<div id="logo">
		</div>
		<form Action="<c:url value='LoginServlet' />" method="POST">

			<H1 id="title">Sign in to GuMi</H1>
			
			<div id="errorText" class="inputTable">
				<small><font>${errorMsg.error_memID}</font></small>
				<small><font>${errorMsg.error_memPWD}</font></small>
			</div>

			<div class="inputTable">
				<label for="memID">帳號： </label>
				<input id="memID" class="inputBox" type="text" name="memID" size="10">
				
				<label for="memPWD">密碼： </label><a href="<c:url value='/member_system/reset_password.jsp' />"  id="fogot">忘記密碼?</a>
				<input id="memPWD" class="inputBox" type="password" name="memPWD" size="10">
				 
				<input id="subnitBottun" type="submit" value="Sign In">
			</div>
		</form>
	</div>
	<div id="signUpTable">
		<div id="signUpBox">成為『規秘』的新用戶? <a href="" id="signUp">註冊會員帳號</a></div>
	</div>
	<div id="linkBar">
		<a href="<c:url value='/home.jsp'/>" class="bottomLink">Home</a>
	</div>
</body>
</html>