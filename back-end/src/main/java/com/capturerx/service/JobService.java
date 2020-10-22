package com.capturerx.service;

import com.capturerx.dao.Job;
import com.capturerx.enumeration.Status;
import com.capturerx.repository.JobRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public long saveRequest(String desc) {
        Job job = new Job();
        job.setDescription(desc);
        job.setStatus(Status.NEW);
        jobRepository.save(job);

        job = jobRepository.findByDescription(desc);
        return job.getId();
    }

    public Status getJobStatus(long jobId) {
        Job job = jobRepository.findById(jobId);
        return job.getStatus();
    }

    public Job getJobDetails(long jobId) {
        return jobRepository.findById(jobId);
    }

    public void updateJobStatus(long jobId, Status jobStatus) {
        Job job = jobRepository.findById(jobId);
        job.setStatus(jobStatus);
        jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
