package chat_system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

/**
 * 
 * 聊天室後端服務WebSocket
 *
 */
@ServerEndpoint("/websocket")
public class ChatServer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");	// 日期格式化
	private static Vector<Session> room = new Vector<Session>();

	@OnOpen
	public void open(Session session) {
		// 初始化聊天室
		System.out.println("OnOpen");
		room.addElement(session);
		
	}
	
	/**
	 * 處理對話訊息
	 * @param message 發話訊息
	 * @param session 對話內容
	 */
	@OnMessage
	public void getMessage(String message, Session session) {
		
		System.out.println("OnMessage");
		
		// 取得前端的客戶端訊息,轉換成JSON物件
		JSONObject jsonObject = JSONObject.fromObject(message);
		// 建立訊息傳送時間至JSON物件
		jsonObject.put("date", DATE_FORMAT.format(new Date()));
		// 將儲存訊息的JSON物件傳回所有前端使用者
		for (Session openSession : room) {
			// 判斷此session前端使用者是否為發話者
			jsonObject.put("isSelf", openSession.equals(session));
			// 以JSON格式傳送發話訊息內容,至遠端該session的前端使用者
			openSession.getAsyncRemote().sendText(jsonObject.toString());
			System.out.println(jsonObject.toString());
			System.out.println();
		}
		
	}

	@OnClose
	public void close(Session session) {
		// 關閉聊天室
		System.out.println("OnClose");
		room.remove(session);
	}

	@OnError
	public void error(Throwable t) {
		System.out.println("onError");
		System.out.println(t.getCause());
	}
}