package com.capturerx.controller;

import com.capturerx.dao.Job;
import com.capturerx.enumeration.Status;
import com.capturerx.service.JobService;
import com.capturerx.service.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class JobController {
    private final JobService jobService;
    private final KafkaProducer kafkaProducer;

    @PostMapping("/add")
    public long saveRequest(@RequestBody Job job) {
        long jobId = jobService.saveRequest(job.getDescription());
        kafkaProducer.send(jobId);
        return jobId;
    }

    @GetMapping("/find/{jobId}")
    public Status getJobStatus(@PathVariable("jobId") long jobId) {
        return jobService.getJobStatus(jobId);
    }

    @GetMapping("/find/job/{jobId}")
    public Job getJobDetails(@PathVariable("jobId") long jobId) {
        return jobService.getJobDetails(jobId);
    }

    @GetMapping("/list")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
}
