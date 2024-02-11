package com.javaproject.JobApplication.service;

import com.javaproject.JobApplication.modal.Job;
import com.javaproject.JobApplication.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {


//    private List<Job> jobs = new ArrayList<>();
//
//    private Long nextId = 1L;

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobService(){
        return jobRepository.findAll();
    }

    public Job getJobByIdService(Long jobId){
//        for(Job job : jobs){
//            if(job.getId().equals(jobId)){
//                return job;
//            }
//        }
        return jobRepository.findById(jobId).orElse(null);
    }

    public String createJobService(Job job){
//        job.setId(nextId++);
//        jobs.add(job);
        jobRepository.save(job);
        return "added success";
    }

    public Boolean removeJobByIdService(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//            if (job.getId().equals(id)) {
//                iterator.remove();
//                return job; // Job found and removed
//            }
//        }
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public Job updateJobByIdService(Long id, Job job){
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()) {
//            Job cur_job = iterator.next();
//            if (cur_job.getId().equals(id)) {
//                cur_job.setTitle(job.getTitle());
//                cur_job.setDescription(job.getDescription());
//                cur_job.setLocation(job.getLocation());
//                cur_job.setMinSalary(job.getMinSalary());
//                cur_job.setMaxSalary(job.getMaxSalary());
//                return cur_job; // Job found and removed
//            }
//        }
//        return null;

        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job cur_job = jobOptional.get();
            cur_job.setTitle(job.getTitle());
            cur_job.setDescription(job.getDescription());
            cur_job.setLocation(job.getLocation());
            cur_job.setMinSalary(job.getMinSalary());
            cur_job.setMaxSalary(job.getMaxSalary());
            jobRepository.save(cur_job);
            return cur_job;
        }

        return null;
    }
}
