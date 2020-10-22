package com.capturerx.service;

import com.capturerx.enumeration.Status;
import com.capturerx.utils.sleepTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {
    private final JobService jobService;

    @KafkaListener(topics = "test1", groupId = "group_id")
    public void consume(String jobId) throws InterruptedException {
        log.info("******************* Consumed message: {}", jobId);
        jobService.updateJobStatus(Long.parseLong(jobId), Status.IN_PROGRESS);
        log.info("******************* Processing message {}", jobId);
        Thread.sleep(new sleepTime().generateRandomSleepTime(5000, 1000));
        jobService.updateJobStatus(Long.parseLong(jobId), Status.DONE);
        log.info("******************* Done Consumed message {}", jobId);
    }
}
