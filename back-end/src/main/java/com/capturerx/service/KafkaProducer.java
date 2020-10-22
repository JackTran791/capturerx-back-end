package com.capturerx.service;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(long jobId) {
        kafkaTemplate.send("test1", String.valueOf(jobId));
        log.info("Sending a message: {}", jobId);
    }
}
