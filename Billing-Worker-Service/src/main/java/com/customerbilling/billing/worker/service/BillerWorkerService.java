package com.customerbilling.billing.worker.service;

import com.customerbilling.billing.worker.DTO.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class BillerWorkerService {
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void charge(Transaction transaction) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted", e);
        }

        log.info("persisted " + transaction);
        log.info("Transaction Details Received is.. " + transaction);
    }
}
