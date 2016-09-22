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
		if('${errorMsg.error_memPWD}' == ''){
			$(memPWDerror).attr("class","noError");
		}
		if('${errorMsg.error_newPWD}' == ''){
			$(newPWDerror).attr("class","noError");
		}
		if('${errorMsg.error_checkPWD}' == ''){
			$(checkPWDerror).attr("class","noError");
		}
	});
</script>
<title>Modify Password - GUEMI</title>
</head>
<body id="page">
	
	<div id="modifyPWDTable">
		<div id="logo">
		</div>
		<form Action="<c:url value='ModifyPWDServlet' />" method="POST">

			<H1 id="title">Modify your password</H1>

			<div class="inputTable">
				
				<label for="memPWD">舊密碼： </label>
					<div id="memPWDerror" class="errorMsg">
						<small><font>${errorMsg.error_memPWD}</font></small>
					</div>
				<input id="memPWD" class="inputBox" type="password" name="memPWD" size="10">
				
				
				<label for="newPWD">新密碼： </label>
					<div id="newPWDerror" class="errorMsg">
						<small><font>${errorMsg.error_newPWD}</font></small>
					</div>
				<input id="newPWD" class="inputBox" type="password" name="newPWD" size="10">
				
				
				<label for="checkPWD">新密碼確認： </label>
					<div id="checkPWDerror" class="errorMsg">
						<small><font>${errorMsg.error_checkPWD}</font></small>
					</div>
				<input id="checkPWD" class="inputBox" type="password" name="checkPWD" size="10">
				 
				 
				<input id="subnitBottun" type="submit" value="Update">
			</div>
		</form>
	</div>
	
	<div id="linkBar">
		<a href="<c:url value='/home.jsp'/>" class="bottomLink">Home</a>
	</div>
</body>
</html>