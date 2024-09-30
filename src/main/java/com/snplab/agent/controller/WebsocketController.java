package com.snplab.agent.controller;

import com.snplab.agent.handler.WebSocketHandler;
import com.snplab.agent.rabbitmq.service.RabbitMqService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class WebsocketController {

    private final WebSocketHandler webSocketHandler;

    private final RabbitMqService rabbitMqService;

    // 트리거를 발생시키기 위한 메서드
    @GetMapping("/control-server/trigger")
    public ResponseEntity<?> triggerEvent() {
        String notification = "hello slave";
        webSocketHandler.broadcast(new JSONObject().put("result", "success"));

        return ResponseEntity.ok().build();
    }

    @GetMapping("/execute-server/save")
    public ResponseEntity<?> save() {
        return ResponseEntity.ok().body("data saved");
    }

}
