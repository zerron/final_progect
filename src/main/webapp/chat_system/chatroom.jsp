<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/style_chatroom.css' />" rel="stylesheet" type="text/css" />
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script>
	$(function() {
		var socket = new WebSocket(
				'ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket');
		socket.onmessage = function(event) {
			addMessage(event.data);
		};
		/*
		socket.onclose = function(event) {
			alert(event.code);
		};
		*/
		
		$(document).keydown(function(e){
			if(e.which == 13 || e.keyCode == 13){
				sendMessage();
			}
		});

		$('#send').on('click', function(){
			sendMessage();
		});
		
		function sendMessage() {
			var msg = $('#message').val();
			$('#message').val("");
			var name = "${Login.name}";
			if(msg != "") {
				socket.send(JSON.stringify({
					content : msg,
					nickname : name
				}));
			}
		}

		function addMessage(message) {
			message = JSON.parse(message);
			var messageItem = message.nickname + ": " + message.content + "\r\n";
	        $('#messagesArea').val($('#messagesArea').val() + messageItem);
	        $('#messagesArea').scrollTop($('#messagesArea').prop("scrollHeight"));
		}
	});
</script>

<title>Chat Room - GUEMI</title>
</head>
<body>
	<div id="chatroom">
		<span id="title">GUEMI 聊天室</span>
	
		<textarea id="messagesArea" readonly ></textarea>
	</div>
	
	<div id="message_input">
		<div style="display:inline;">
			<input id="message" name="message" type="text" placeholder="請輸入訊息" />
		</div>
		<div id="send_button" style="display:inline;">
			<input id="send" class="button" type="button" value="送出" />
			<input id="quit" class="button" type="button" value="離開" onclick="history.back()" />
		</div>
	</div>
	






</body>
</html>