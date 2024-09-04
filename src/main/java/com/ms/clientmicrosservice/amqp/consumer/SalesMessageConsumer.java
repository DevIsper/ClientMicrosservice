package com.ms.clientmicrosservice.amqp.consumer;

import com.ms.clientmicrosservice.amqp.config.RabbitMQConfig;
import com.ms.clientmicrosservice.model.ClientModel;
import com.ms.clientmicrosservice.repository.IClientRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class SalesMessageConsumer {

    @Autowired
    private IClientRepository clientRepository;

    @RabbitListener(queues = RabbitMQConfig.queueOrderCreated)
    public void handleNewSaleMessage(@Payload String message) {

        String[] split = message.split(":");

        UUID clientID = UUID.fromString(split[0].trim());
        UUID orderID = UUID.fromString(split[1].trim());

        if(clientRepository.existsByClientExternalID(clientID)){
            ClientModel c = clientRepository.findByClientExternalID(clientID);
            
            if(c.getPurchaseList() == null){
                c.setPurchaseList(new ArrayList<>());
            }

            c.getPurchaseList().add(orderID.toString());
            clientRepository.save(c);
        }
    }
}
