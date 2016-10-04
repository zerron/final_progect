<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>規秘團隊</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
</head>
<body>
	<!-- Header -->
	<header id="header">
		<div class="inner">
			<a class="logo">關於我們</a>
			<nav id="nav">
				<a href="<c:url value='/home.jsp' />">首頁</a>
			</nav>
			<a href="#navPanel" class="navPanelToggle"><span
				class="fa fa-bars"></span></a>
		</div>
	</header>
	
	<!-- Banner -->
	<section id="banner">
		<h1>Welcome to 規秘</h1>
		<p>規秘團隊『比你還了解你』</p>
	</section>
	
	<section id="two" class="wrapper style1 special">
		<div class="inner">
			<header>
				<h2>團隊成員</h2>
				<p>All about us</p>
			</header>
			<div class="flex flex-4">
				<div class="box person">
					<div class="image round">
						<IMG src="<c:url value='/images/team03.jpg' />"
							onMouseOver="this.style.filter='gray'"
							onMouseOut="this.style.filter=null">
					</div>
					<h3>博崴</h3>
					<p>組長</p>
				</div>
				<div class="box person">
					<div class="image round">
						<img src="<c:url value='/images/team04.jpg' />" alt="Person 2" />
					</div>
					<h3>源桀</h3>
					<p>系統工程師</p>
				</div>
				<div class="box person">
					<div class="image round">
						<img src="<c:url value='/images/team05.jpg' />" alt="Person 3" />
					</div>
					<h3>志儒</h3>
					<p>App程式設計</p>
				</div>
				<div class="box person">
					<div class="image round">
						<img src="<c:url value='/images/team08.png' />" alt="Person 4" />
					</div>
					<h3>哲鋒</h3>
					<p>資料庫設計</p>
				</div>
				<div class="box person">
					<div class="image round">
						<img src="<c:url value='/images/team06.jpg' />" alt="Person 5" />
					</div>
					<h3>書瑋</h3>
					<p>App程式設計</p>
				</div>
				<div class="box person">
					<div class="image round">
						<img src="<c:url value='/images/team07.png' />" alt="Person 6" />
					</div>
					<h3>世華</h3>
					<p>前端網頁設計</p>
				</div>
				
			</div>
		</div>
	</section>
	</div>
	</div>
	<footer id="footer">
		<div class="inner">
			<div class="flex">
				<div class="copyright">&copy; 規秘團隊 All rights reserved.</div>
				<iframe
					src="https://www.facebook.com/plugins/like.php?href=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&width=450&layout=standard&action=like&show_faces=true&share=true&height=80&appId"
					width="450" height="80" style="border: none; overflow: hidden"
					scrolling="no" frameborder="0" allowTransparency="true"></iframe>
				<ul class="icons">
					<li><a href="#" class="icon fa-facebook"><span
							class="label">Facebook</span></a></li>
					<li><a href="#" class="icon fa-twitter"><span
							class="label">Twitter</span></a></li>
					<li><a href="#" class="icon fa-linkedin"><span
							class="label">linkedIn</span></a></li>
					<li><a href="#" class="icon fa-pinterest-p"><span
							class="label">Pinterest</span></a></li>
					<li><a href="#" class="icon fa-vimeo"><span class="label">Vimeo</span></a></li>
				</ul>
			</div>
		</div>
	</footer>
	<!-- Scripts -->
	<script src="<c:url value='/js/jquery.min.js' />"></script>
	<script src="<c:url value='/js/aboutus_skel.min.js' />"></script>
	<script src="<c:url value='/js/aboutus_util.js' />"></script>
	<script src="<c:url value='/js/aboutus_main.js' />"></script>
</body>
</html>