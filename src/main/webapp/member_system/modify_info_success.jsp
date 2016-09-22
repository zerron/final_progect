<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/style_member.css' />" rel="stylesheet" type="text/css">
<script>
	setTimeout(function(){
		location = "<c:url value='/home.jsp'/>";
	}, 3000);
</script>
<title>Modify Information Success - GUEMI</title>
</head>
<body id="ground">
	<div id="message">
		<div id="biglogo"></div>
		
		<div id="relativeBlock">
			<div id="successText">更新成功</div>
			<a href="<c:url value='/home.jsp'/>" id="returnButton">返回首頁</a>
		</div>
	</div>
</body>
</html>