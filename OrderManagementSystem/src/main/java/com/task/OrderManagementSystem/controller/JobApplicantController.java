package com.task.OrderManagementSystem.controller;

import com.task.OrderManagementSystem.dto.ApplicationResponse;
import com.task.OrderManagementSystem.dto.CreateCustomerDTO;
import com.task.OrderManagementSystem.model.Customer;
import com.task.OrderManagementSystem.model.JobApplicant;
import com.task.OrderManagementSystem.service.JobApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jobapply")
public class JobApplicantController {

    private final JobApplicantService jobApplicantService;

    public JobApplicantController(JobApplicantService jobApplicantService) {
        this.jobApplicantService = jobApplicantService;
    }

    @PostMapping
    public ResponseEntity<ApplicationResponse<JobApplicant>> createJobApplicant(@RequestBody JobApplicant JobApplicant){
        ApplicationResponse<JobApplicant> response = new ApplicationResponse<>(jobApplicantService.createJobApplicant(JobApplicant));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
