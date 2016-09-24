<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="<c:url value='/css/sport_main.css' />" rel="stylesheet" type="text/css">
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script>
	$(document).ready(function(){
		var str = ${pageContext.request.queryString};
		if(str != null) {
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
	<header id="header" >
	<div class="inner">
		<div class="content">
			<h1>運動休閒</h1>
			<h2>
				無論晴天雨天<br /> 尋找一個最適合你的地方
			</h2>
			<a class="button big alt keep"><span>出發</span></a> 
			<a href="<c:url value='/home.jsp' />" class="button big alt"><span>回首頁</span></a>
		</div>
		<a class="button hidden keep"><span></span></a>
	</div>
	</header>

	<!-- Main -->
	<div id="main">
		<div class="inner">
			<div class="columns">

				<!-- Column 1 (horizontal, vertical, horizontal, vertical) -->
				<div class="image fit">
					<a href="sport_detail.jsp"><img src="../images/banner.jpg"
						title="大安運動中心" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic02.jpg"
						title="極限運動訓練中心" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic03.jpg"
						title="內湖運動公園" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic04.jpg"
						title="台北小巨蛋" alt="" /></a>
				</div>

				<!-- Column 2 (vertical, horizontal, vertical, horizontal) -->
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic06.jpg"
						title="松山運動中心潛水" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic05.jpg"
						title="臺大體育館" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic08.jpg" title="瑜珈境"
						alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic07.jpg" title="體育客"
						alt="" /></a>
				</div>

				<!-- Column 3 (horizontal, vertical, horizontal, vertical) -->
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic09.jpg"
						title="古亭河濱公園" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic12.jpg" title="蜂運動"
						alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic11.jpg"
						title="世界健身中心-公館店" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic10.jpg"
						title="萬華運動中心" alt="" /></a>
				</div>

				<!-- Column 4 (vertical, horizontal, vertical, horizontal) -->
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic13.jpg"
						title="中正運動中心" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic14.jpg"
						title="大直橋迎風河濱公園" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic15.jpg"
						title="內湖運動中心" alt="" /></a>
				</div>
				<div class="image fit">
					<a href="detail1.html"><img src="images/pic16.jpg"
						title="西盛環保河濱公園籃球場" alt="" /></a>
				</div>

			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer id="footer"> <a href="#"
		class="info fa fa-info-circle"><span>About</span></a>
	<div class="inner">
		<div class="content">
			<h3>--------------------</h3>
			<p>___________________________________________________________________</p>
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
				&copy; <a href="<c:url value='/about_us.jsp' />">規秘團隊</a> All rights reserved. | 國立台北科技大學Java & Android程式設計人才養成班
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