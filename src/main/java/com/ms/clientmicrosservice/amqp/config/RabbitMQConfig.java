package com.ms.clientmicrosservice.amqp.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    // Queues
    public static final String queueOrderCreated = "queue.order.created";

}
