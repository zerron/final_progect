<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="<c:url value='/css/sport_main.css' />" rel="stylesheet" type="text/css">
<title>Sport Detail - GUEMI</title>
</head>
<body>
	<!-- Header -->
	<header id="header" class="preview">
	<div class="inner">
		<a href="<c:url value='/sport_system/sport_main.jsp?a=1' />" class="button hidden"><span></span></a>
	</div>
	</header>


	<!-- Main -->
	<div id="preview">
		<div class="inner">
			<div class="image fit">
				<img src="images/pic05.jpg" alt="" />
			</div>
			<div class="content">
				<header>
				<h2>國立臺灣大學綜合體育館 NTU Sports Center</h2>
				</header>
				<p>國立臺灣大學綜合體育館（NTU Sports
					Center）為同時具備大型活動場地及運動中心之現代化多功能體育館，除了交通便利以及場館大小適中外，也同時提供了全校師生、企業團體及一般民眾最佳的教學、休閒、運動及大型活動場地。

				</p>
				<p>
					地址：臺北市羅斯福路四段一號&nbsp<a
						href="http://ntusportscenter.ntu.edu.tw/front/index.aspx">台大綜合體育館</a>
				</p>
				<p>本館開放時間 週一~週五 6:00 ~ 22:00 週六 9:00 ~ 22:00 週日 9:00 ~18:00</p>
				<p>運動類型：籃球場、排球場、手球場、游泳池、重量訓練室、壁球室、桌球室、羽球場</p>
				<p>收費/免費：收費</p>
			</div>
		</div>
		<a href="detail1.html" class="nav previous"><span
			class="fa fa-chevron-left"></span></a> <a href="detail2.html"
			class="nav next"><span class="fa fa-chevron-right"></span></a>
	</div>

	<!-- Footer -->
	<footer id="footer"> <a href="#"
		class="info fa fa-info-circle"><span>About</span></a>
	<div class="inner">
		<div class="content">
			<h3>會員使用心得分享</h3>
			<p>我想分享</p>
			<p>剛開始進入健身房，很多重訓設備都不會操作，就連最基本的啞鈴都不會舉，裡面的值班教練，好的對我敷衍了事，壞的用年齡的限制趕我走，大概小胖子到哪裡都惹人厭吧！最後我只好自己嘗試，然而由於姿勢不對，效果沒練到而且還受傷，真的是很氣餒。不過幸好有一位好心的先生（以下稱呼他為師傅，因為我們現在仍然一起練重訓）願意教我各種設備的使用方法及身體各部位的訓練方式，讓我開始進入正軌</p>

		</div>
		<div class="copyright">
			<h3>進入聊天室</h3>
			<p>目前線上人數：</p>
			<h4>加入我的行事曆</h4>
			<!-- <ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
						</ul> -->
			<!-- &copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com/">Unsplash</a>. -->
		</div>
	</div>
	</footer>

	<!-- Scripts -->
	<script src="<c:url value='/js/jquery.min.js' />"></script>
	<script src="<c:url value='/js/sport_skel.min.js' />"></script>
	<script src="<c:url value='/js/sport_util.js' />"></script>
	<script src="<c:url value='/js/sport_main.js' />"></script>
</body>
</html>