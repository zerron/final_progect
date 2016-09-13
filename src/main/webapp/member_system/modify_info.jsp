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
		if('${errorMsg.error_memNAME}' == ''){
			$(memNAMEerror).attr("class","noError");
		}
		if('${errorMsg.error_memPHN}' == ''){
			$(memPHNerror).attr("class","noError");
		}
		if('${errorMsg.error_memEMAIL}' == ''){
			$(memEMAILerror).attr("class","noError");
		}
		if('${Login.gender}' == 1) {
			$(memMAN).attr("checked","");
		} else {
			$(memFEMAN).attr("checked","");
		}
	});
</script>
<title>Modify Information</title>
</head>
<body id="page">
	
	<div id="signUpForm">
		<div id="logo">
		</div>
		<form Action="<c:url value='ModifyInfoServlet' />" method="POST">

			<H1 id="title">Modify your member information</H1>

			<div class="inputTable">
				
				<label for="memNAME">姓名： </label>
					<div id="memNAMEerror" class="errorMsg">
						<small><font>${errorMsg.error_memNAME}</font></small>
					</div>
				<input id="memNAME" class="inputBox" type="text" name="memNAME" size="10" value="${Login.name}">
				
				
				<label for="memPHN">手機： </label>
					<div id="memPHNerror" class="errorMsg">
						<small><font>${errorMsg.error_memPHN}</font></small>
					</div>
				<input id="memPHN" class="inputBox" type="text" name="memPHN" size="10" value="${Login.phone}">
				
				
				<label for="memEMAIL">Email： </label>
					<div id="memEMAILerror" class="errorMsg">
						<small><font>${errorMsg.error_memEMAIL}</font></small>
					</div>
				<input id="memEMAIL" class="inputBox" type="text" name="memEMAIL" size="10" value="${Login.email}">
				
				
				<label for="memGEN">性別： </label>
				<input id="memMAN" name="memGEN" type="radio" value="1" size="20">男 
				<input id="memFEMAN" name="memGEN" type="radio" value="2" size="20">女
			
						 
				<input id="subnitBottun" type="submit" value="Update">
			</div>
		</form>
	</div>
	
	<div id="linkBar">
		<a href="<c:url value='/home.jsp'/>" class="bottomLink">Home</a>
	</div>
</body>
</html>