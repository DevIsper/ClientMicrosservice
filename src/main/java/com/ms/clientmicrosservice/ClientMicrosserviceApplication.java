package com.ms.clientmicrosservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ClientMicrosserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientMicrosserviceApplication.class, args);
    }

}
