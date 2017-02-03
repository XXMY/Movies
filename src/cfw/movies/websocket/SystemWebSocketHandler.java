package cfw.movies.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cfw on 2016/8/21.
 */
@Component
public class SystemWebSocketHandler implements WebSocketHandler {
    private static final List<WebSocketSession> webSocketSessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("Connect to webSocket success ...");
        webSocketSession.sendMessage(new TextMessage("Server: Connect OK!"));
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        TextMessage returnMessage = new TextMessage("Server Received: "+webSocketMessage.getPayload());
        webSocketSession.sendMessage(returnMessage);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.err.println("Server socket closed.");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
