<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value='/css/default.css' />" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/css/fonts.css' />" rel="stylesheet" type="text/css" media="all" />
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script>
	$(document).ready(function(){
		$(member).click(function(){
			if('${Login}' == '') {
				if($(beforeLogin).css('display') == 'none')
					$(beforeLogin).css('display', '');
				else
					$(beforeLogin).css('display', 'none');
			} else {
				if($(afterLogin).css('display') == 'none')
					$(afterLogin).css('display', '');
				else
					$(afterLogin).css('display', 'none');
			}
		});
	});
</script>
</head>
<title>規秘 - GUEMI</title>
<body>
<div id="header" class="container">
	<div id="logo">
		<h1><a href="#">規&nbsp秘</a><img src="<c:url value='/images/art-clipboard.jpg' />" width="50" height="50">	</h1>
	</div>
	<div id="menu">
		<ul>
			<li class="active"><a href="" accesskey="1" title="">首頁</a></li>
			<li><a href="<c:url value='/about_us.jsp' />" accesskey="3" title="">關於我們</a></li>
			<li id="member"><span>會員專區</span></li>
			<li><a href="mailto:greatmeeting@gmail.com" accesskey="5" title="">聯絡我們</a></li>
		</ul><br>
		<div id="beforeLogin" style="display:none;">
			<ul>
				<li><a href="<c:url value='/member_system/sign_up.jsp' />">會員註冊</a></li>
				<li><a href="<c:url value='/member_system/sign_in.jsp' />">會員登入</a></li>
			</ul>
		</div style="display:none;">
		<div id="afterLogin" style="display:none;">
			<ul>
				<li><a href="<c:url value='/member_system/modify_info.jsp' />">修改會員資料</a></li>
				<li><a href="<c:url value='/member_system/modify_password.jsp' />">修改會員密碼</a></li>
				<li><a href="<c:url value='/member_system/LogoutServlet' />">會員登出</a></li>
			</ul>
		</div>
	</div>
</div>
<div id="banner"></div>
<div id="page" class="container">
	<div class="boxA">
		<h2>運動休閒</h2>
		<div class="box">
			<a href="<c:url value='/sport_system/sport_main.jsp' />" class="image image-full"><img src="<c:url value='/images/pic01.jpg' />" alt="" /></a>
			<span>Sport</span>
		</div>
		<p>剛開始進入健身房，很多重訓設備都不會操作，就連最基本的啞鈴都不會舉，裡面的值班教練，好的對我敷衍了事，壞的用年齡的限制趕我走，大概小胖子到哪裡都惹人厭吧！最後我只好自己嘗試，然而由於姿勢不對，效果沒練到而且還受傷，真的是很氣餒。不過幸好有一位好心的先生（以下稱呼他為師傅，因為我們現在仍然一起練重訓）願意教我各種設備的使用方法及身體各部位的訓練方式，讓我開始進入正軌</p>
	   <a href="http://www.facebook.com/sharer.php?u=http://www.wfublog.com/" target="_blank"><P Align=center><img src="<c:url value='/images/fb.jpg' />" ></a>
    </div>

	<div class="boxB">
		<h2>城市景點</h2>
		<div class="box">
			<a href="" class="image image-full"><img src="<c:url value='/images/pic02.jpg' />" alt="" /></a>
			<span>Attraction</span>
		</div>
		<p>在高樓林立的都市叢林裡　

綠地　農耕　似乎成了遙不可及的夢想

住慣鄉間的媽媽　現在跟我一起住在台北市區

總嘆著沒地方可去

這幾年綠農產業興起　小規模的城市微型農耕

不但是股潮流　也是城市公民文化與社區營造運動的重要趨勢

最近發現台北車站附近的華山大草原　推出華山綠工場活動

在繁忙的台北市區中　打造一處都市桃花源般的綠色菜園

我立刻就帶著媽媽　來這體驗當城市農夫的樂趣</p>
   <a href="http://www.facebook.com/sharer.php?u=http://www.wfublog.com/" target="_blank"><P Align=center><img src="<c:url value='/images/fb.jpg' />" ></a>
	</div>

	<div class="boxC">
		<h2>街坊美食</h2>
		<div class="box">
			<a href="<c:url value='/home.jsp'/>" class="image image-full"><img src="<c:url value='/images/pic03.jpg' />" alt="" /></a>
			<span>Food</span>
		</div>
		<p>總的來講，餐廳的環境十分舒服，西式的裝橫風格，搭配柔和的燈光，營造出一個十分優雅的飲食氛圍。服務員的態度也十分友善，每當我需要幫助的時候總能及時為我解決問題，服務效率之高是很少見的。
食物方面，不得不說，這是我吃過的最正宗的德國菜!!豬手、麵包和啤酒，滿分!!100%德國風味！
提醒各位，晚上去餐廳可是很多人的哦，想要吃正宗德國菜就要早一點啦</p>
	   <a href="http://www.facebook.com/sharer.php?u=http://www.wfublog.com/" target="_blank"><P Align=center><img src="<c:url value='/images/fb.jpg' />" ></a>
    </div>
    
</div>
    <div id="featured" class="container">
	<div class="align-left">
    <img src="<c:url value='/images/art-clipboard.jpg' />" width="260" height="260" alt="Person 1" />			
	</div>
	<div class="align-right">
		<p>我們是 <strong>規秘</strong> ，隨著智慧型手機的普及與多樣化的功能，人們的生活越來越與使用手機密不可分

搭車時，滑一下……
想偷懶，滑一下……
下班了，滑一下……
好無聊！滑一下……
儘管科技進步日新月異，
卻還是沒能解決人們心裡的「無聊」。
現在，別煩惱了！交給『比你還了解你』的我們來「選擇」吧！
 </p>	
		<a href="<c:url value='/about_us.jsp' />" class="button">認識更多</a>
	</div>
</div>
	

<div id="copyright" class="container">
	<p>&copy; 規秘團隊 All rights reserved. | 10608台北市忠孝東路三段一號 | 國立台北科技大學Java & Android程式設計人才養成班</p>
 
    </div>
</body>
</html>