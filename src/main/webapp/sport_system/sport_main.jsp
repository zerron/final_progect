<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id='sportDAO' class='sport_system.model.SportHibernate'
	scope='page' />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="<c:url value='/css/sport_main.css' />" rel="stylesheet"
	type="text/css">
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script>
	$(document).ready(function() {
		var str = "${pageContext.request.queryString}";
		if (str != "") {
			$('#header').attr('class', 'hide');
		}
	});
</script>
<title>Sport - GUEMI</title>
</head>
<body>

	<!-- 判斷查詢字串 -->

	<!-- Header -->
	<div id="5555555"></div>
	<header id="header">
	<div class="inner">
		<div class="content">
			<h1>運動休閒</h1>
			<h2>
				無論晴天雨天<br /> 尋找一個最適合你的地方
			</h2>
			<a class="button big alt keep"><span>出發</span></a> <a
				href="<c:url value='/home.jsp' />" class="button big alt"><span>回首頁</span></a>
		</div>
		<a class="button hidden keep"><span></span></a>
	</div>
	</header>

	<!-- Main -->
	<div id="main">
		<div class="inner">
			<div class="columns">
				<c:forEach var='sport' items='${sportDAO.allSports}' varStatus="vs">
					<div class="image fit">
					<a href="<c:url value='/sport_system/GetDetailServlet?no=${sport.ID}' />">
						<img src="${pageContext.request.contextPath}/sport_system/controller/GetImage?no=${sport.ID}" />
					</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<!-- Footer -->
	<footer id="footer"> <a href="#"
		class="info fa fa-info-circle"><span>About</span></a>
	<div class="inner">
		<div class="content">
			<!-- 
			<h3>--------------------</h3>
			<p>___________________________________________________________________</p>
		 -->
		</div>
		<div class="copyright">
			<h3>Follow me</h3>
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-dribbble"><span
						class="label">Dribbble</span></a></li>
			</ul>
			<p>
				&copy; <a href="<c:url value='/about_us.jsp' />">規秘團隊</a> All rights
				reserved. | 國立台北科技大學Java & Android程式設計人才養成班
			</p>

		</div>
	</div>
	</footer>

	<!-- Scripts -->
	<script src="<c:url value='/js/sport_skel.min.js' />"></script>
	<script src="<c:url value='/js/sport_util.js' />"></script>
	<script src="<c:url value='/js/sport_main.js' />"></script>

</body>
</html>