package com.snplab.agent.rabbitmq.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.rabbitmq")
@Getter
@Setter
public class RabbitMqProperties {

    private String host;
    private int port;
    private String username;
    private String password;
}
