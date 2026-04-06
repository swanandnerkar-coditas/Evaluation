package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.dto.ErrorResponse;
import com.task.OrderManagementSystem.model.JobApplicant;

import java.util.List;

public interface JobApplicantService {
    JobApplicant createJobApplicant(JobApplicant jobApplicant);
}
