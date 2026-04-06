package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.model.JobApplicant;
import com.task.OrderManagementSystem.repo.JobApplicantRepo;
import org.springframework.stereotype.Service;

@Service
public class JobApplicantServiceImpl implements JobApplicantService{

    private final JobApplicantRepo jobApplicantRepo;

    public JobApplicantServiceImpl(JobApplicantRepo jobApplicantRepo) {
        this.jobApplicantRepo = jobApplicantRepo;
    }

    @Override
    public JobApplicant createJobApplicant(JobApplicant jobApplicant) {
        return jobApplicantRepo.save(jobApplicant);
    }
}
