package com.customerbilling.billing.service;

import com.customerbilling.billing.model.Transaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducerService {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    public void sendMessage(Transaction transaction) {
        rabbitTemplate.convertAndSend(exchange, routingKey, transaction);
    }

}
