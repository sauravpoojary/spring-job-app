package com.javaproject.JobApplication.repository;

import com.javaproject.JobApplication.modal.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
