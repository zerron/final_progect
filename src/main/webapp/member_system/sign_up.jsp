<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/style_member.css' />" rel="stylesheet" type="text/css">
<script src='https://www.google.com/recaptcha/api.js'></script>
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script>
	$(document).ready(function(){
		if('${errorMsg.error_memID}' == ''){
			$(memIDerror).attr("class","noError");
		}
		if('${errorMsg.error_memPWD}' == ''){
			$(memPWDerror).attr("class","noError");
		}
		if('${errorMsg.error_checkPWD}' == ''){
			$(checkPWDerror).attr("class","noError");
		}
		if('${errorMsg.error_memNAME}' == ''){
			$(memNAMEerror).attr("class","noError");
		}
		if('${errorMsg.error_memPHN}' == ''){
			$(memPHNerror).attr("class","noError");
		}
		if('${errorMsg.error_memEMAIL}' == ''){
			$(memEMAILerror).attr("class","noError");
		}
		if('${errorMsg.error_reCAPTCHA}' == ''){
			$(reCAPTCHAerror).attr("class","noError");
		}
	});
</script>
<title>Sign Up - GUEMI</title>
</head>
<body id="page">
	
	<div id="signUpForm">
		<div id="logo">
		</div>
		<form Action="<c:url value='RegisterServlet' />" method="POST">

			<H1 id="title">Join GUEMI</H1>

			<div class="inputTable">
			
				<label for="memID">帳號： </label>
					<div id="memIDerror" class="errorMsg">
						<small><font>${errorMsg.error_memID}</font></small>
					</div>
				<input id="memID" class="inputBox" type="text" name="memID" size="10" value="${member.memberId}">
				
				
				<label for="memPWD">密碼： </label>
					<div id="memPWDerror" class="errorMsg">
						<small><font>${errorMsg.error_memPWD}</font></small>
					</div>
				<input id="memPWD" class="inputBox" type="password" name="memPWD" size="10">
				
				
				<label for="checkPWD">密碼確認： </label>
					<div id="checkPWDerror" class="errorMsg">
						<small><font>${errorMsg.error_checkPWD}</font></small>
					</div>
				<input id="checkPWD" class="inputBox" type="password" name="checkPWD" size="10">
				
				
				<label for="memNAME">姓名： </label>
					<div id="memNAMEerror" class="errorMsg">
						<small><font>${errorMsg.error_memNAME}</font></small>
					</div>
				<input id="memNAME" class="inputBox" type="text" name="memNAME" size="10" value="${member.name}">
				
				
				<label for="memPHN">手機： </label>
					<div id="memPHNerror" class="errorMsg">
						<small><font>${errorMsg.error_memPHN}</font></small>
					</div>
				<input id="memPHN" class="inputBox" type="text" name="memPHN" size="10" value="${member.phone}">
				
				
				<label for="memEMAIL">Email： </label>
					<div id="memEMAILerror" class="errorMsg">
						<small><font>${errorMsg.error_memEMAIL}</font></small>
					</div>
				<input id="memEMAIL" class="inputBox" type="text" name="memEMAIL" size="10" value="${member.email}">
				
				
				<label for="memGEN">性別： </label>
				<input id="memGEN" name="memGEN" type="radio" value="1" size="20" checked>男 
				<input id="memGEN" name="memGEN" type="radio" value="2" size="20">女
			
				 
				<div class="g-recaptcha" data-sitekey="6LdQKCkTAAAAAEO9wlotv41Z74mNE_lQJ7zqQbRN" style="float:left;">	
				</div>
				<div id="reCAPTCHAerror" class="errorMsg">
					<small><font>${errorMsg.error_reCAPTCHA}</font></small>
				</div>				 
				<input id="subnitBottun" type="submit" value="Create an Account">
			</div>
		</form>
	</div>
	
	<div id="linkBar">
		<a href="<c:url value='/home.jsp'/>" class="bottomLink">Home</a>
	</div>
</body>
</html>