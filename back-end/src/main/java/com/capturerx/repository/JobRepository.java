package com.capturerx.repository;

import com.capturerx.dao.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    Job findByDescription(String desc);

    Job findById(long id);
}
