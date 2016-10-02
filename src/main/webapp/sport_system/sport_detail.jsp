<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="<c:url value='/css/sport_main.css' />" rel="stylesheet" type="text/css">
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script>
	$(document).ready(function(){
		var favorite = ${favorite};
		if(favorite == true) {
					$('#like').attr("src", "<c:url value='/images/redheart.png' />");
					$('#like').attr("alt", "red");
 		}
		
		$('#like').on('click', function(){
			var status = $('#like').attr('alt');
			if(status == "white") {
				$('#like').attr("src", "<c:url value='/images/redheart.png' />");
				$('#like').attr("alt", "red");
				// -----------ajax-------------------後端Servlet--------------------
					// ----判斷Login狀態----
					if("${Login.memberId}" != "") {
						$.ajax({
							url: "<c:url value='/sport_system/LikeServlet' />",
 							data: {"memberId":"${Login.memberId}", "sportId":"${itemDetail.ID}"},
							type: "POST"
						});
					}
			} else {
				$('#like').attr("src", "<c:url value='/images/whiteheart.png' />");
				$('#like').attr("alt", "white");
				// -----------ajax-------------------後端Servlet--------------------
					// ----判斷Login狀態----
				if("${Login.memberId}" != "") {
						$.ajax({
							url: "<c:url value='/sport_system/DislikeServlet' />",
 							data: {"memberId":"${Login.memberId}", "sportId":"${itemDetail.ID}"},
							type: "POST"
						});
					}
			}
			
		});
	});	
</script>
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
				<img style="margin:0px auto; width:700px; height:450px;" src="${pageContext.request.contextPath}/sport_system/controller/GetImage?no=${itemDetail.ID}"/>
			</div>
			<div class="content">
				<header>
				<h2>${itemDetail.SPORTNAME}</h2>
				</header>
				<p>
				${itemDetail.DETAIL}</p>
				<p>
				地址：${itemDetail.ADDRESS}<br>
				電話：${itemDetail.PHONE}<br>
				場地類型：${itemDetail.INDOOR}<br>
				運動類型：${itemDetail.ITEAM}<br>
				收費/免費：${itemDetail.COST}</p>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer id="footer"> <a href="#"
		class="info fa fa-info-circle"><span>About</span></a>
	<div class="inner">
		<div class="content">
			<h3>會員使用心得分享</h3>
			<p>我想分享</p>
			<!-- 
			<p>剛開始進入健身房，很多重訓設備都不會操作，就連最基本的啞鈴都不會舉，裡面的值班教練，好的對我敷衍了事，壞的用年齡的限制趕我走，大概小胖子到哪裡都惹人厭吧！最後我只好自己嘗試，然而由於姿勢不對，效果沒練到而且還受傷，真的是很氣餒。不過幸好有一位好心的先生（以下稱呼他為師傅，因為我們現在仍然一起練重訓）願意教我各種設備的使用方法及身體各部位的訓練方式，讓我開始進入正軌</p>
			 -->
		</div>
		<div class="copyright">
			<h4><a href="<c:url value='/chat_system/chatroom.jsp' />">進入聊天室</a></h4>
			<ul class="icons">
			<!-- 
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
			 -->			
							<li><img id="like" alt="white" src="<c:url value='/images/whiteheart.png' />" style="width:35px; height:35px;" /></li>
						</ul>
			&copy; <a href="<c:url value='/about_us.jsp' />">規秘團隊</a> All rights reserved. | 國立台北科技大學Java & Android程式設計人才養成班
		</div>
	</div>
	</footer>

	<!-- Scripts -->
	<script src="<c:url value='/js/sport_skel.min.js' />"></script>
	<script src="<c:url value='/js/sport_util.js' />"></script>
	<script src="<c:url value='/js/sport_main.js' />"></script>
</body>
</html>