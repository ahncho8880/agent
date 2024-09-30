package com.snplab.agent.handler;

import java.net.URI;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends BinaryWebSocketHandler {

    private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        super.afterConnectionEstablished(session);
//        URI uri = session.getUri();
//        String path = Objects.requireNonNull(uri).getPath();
//        String roomId = path.substring(path.lastIndexOf("/") + 1);
//        Optional<CallRoom> optionalCallRoom = callRoomRepository.findByCallRoomId(roomId);
//
//        if (optionalCallRoom.isEmpty() || sessions.contains(session)) {
//            return;
//        }
//
        sessions.add(session);
    }

//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        super.handleMessage(session, message);
//    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
//        super.handleTextMessage(session, message);
//        String messageText = message.getPayload();
//        try {
//            session.sendMessage(new TextMessage("User " + session.getId() + ": " + messageText));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println();
//        super.handleMessage(session, message);
    }

    public void broadcast(String message) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcast(JSONObject json) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(json.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
