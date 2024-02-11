package com.javaproject.JobApplication.controller;

import com.javaproject.JobApplication.modal.Job;
import com.javaproject.JobApplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobService());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobByIdService(id);
        if(job == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeJobById(@PathVariable Long id){
        if(!jobService.removeJobByIdService(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Deleted Successfully!!",HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        return new ResponseEntity<>(jobService.createJobService(job),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJobById(@PathVariable Long id, @RequestBody Job updateJobBody){
        Job job = jobService.updateJobByIdService(id, updateJobBody);
        if(job == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(job, HttpStatus.OK);
    }

}
