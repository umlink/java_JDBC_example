package test.zfl.websocket;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.WebSocketContainer;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/Websocket")
public class Websocket {
	public Websocket(URI endpointURI) {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(this, endpointURI);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@OnOpen
	public void OpenSocket(){
		System.out.println("open_websocket");
	}
	@OnClose 
	public String CloseSocket(){
		return "close_websocket";
	}
	@OnError
	public String ErrorSocket(){
		return "error_websocket";
	}
	@OnMessage
	public String OnMessage(String msg){
		System.out.println(msg);
		return msg;
	}
}
