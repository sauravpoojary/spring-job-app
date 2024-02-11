package com.javaproject.JobApplication.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@Entity
//@Table(name = "job_table") //change table name
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically incremented by JPA
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String minSalary;

    @NonNull
    private String maxSalary;

    @NonNull
    private String location;

    @ManyToOne
    private Company company;
}
