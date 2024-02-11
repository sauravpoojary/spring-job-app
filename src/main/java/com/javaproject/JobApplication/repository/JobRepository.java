package com.javaproject.JobApplication.repository;

import com.javaproject.JobApplication.modal.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
