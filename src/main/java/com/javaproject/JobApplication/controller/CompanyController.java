package com.javaproject.JobApplication.controller;


import com.javaproject.JobApplication.modal.Company;
import com.javaproject.JobApplication.modal.Job;
import com.javaproject.JobApplication.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company){
        Company response = companyService.updateCompany(company,id);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Added Successfully ...",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        return companyService.deleteCompany(id) ? new ResponseEntity<>("Company Deleted Successfully..",HttpStatus.OK)
                : new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);

    }



}
