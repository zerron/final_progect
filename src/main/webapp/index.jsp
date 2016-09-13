<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>會員系統 測試</h2>
	<a href="<c:url value='member_system/sign_up.jsp' />">註冊會員</a>
	<a href="<c:url value='member_system/sign_in.jsp' />">會員登入</a>
	<a href="<c:url value='member_system/Logout.jsp' />">會員登出</a>
	<a href="<c:url value='member_system/modify_info.jsp' />">修改會員</a>
	<a href="<c:url value='member_system/modify_password.jsp' />">修改密碼</a>
	<a href="<c:url value='member_system/reset_password.jsp' />">密碼重置</a>
</body>
</html>

