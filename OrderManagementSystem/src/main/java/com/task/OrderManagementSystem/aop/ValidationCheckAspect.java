package com.task.OrderManagementSystem.aop;

import com.task.OrderManagementSystem.exception.ValidationException;
import com.task.OrderManagementSystem.model.JobApplicant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationCheckAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(ValidationCheckAspect.class);

    @Pointcut("execution (* com.task.OrderManagementSystem.controller.*.*(..))")
    public void forAllController(){}

    @Pointcut("execution (* com.task.OrderManagementSystem.service.*.*(..))")
    public void forAllService(){}

    @Pointcut("execution (* com.task.OrderManagementSystem.repo.*.*(..))")
    public void forAllRepo(){}

    @Pointcut("execution (* com.task.OrderManagementSystem.exception.*.*(..))")
    public void forAllException(){}

    @Pointcut("execution (* com.task.OrderManagementSystem.service.JobApplicantServiceImpl.createJobApplicant(..))")
    public void forUploadResume(){}

    /*
        to validate & apply constraint on Resume to upload
     */
    @Before("forUploadResume()")
    public void beforeUploadResume(JoinPoint joinPoint){
        Object[] obj = joinPoint.getArgs();
        JobApplicant jobApplicant = (JobApplicant) obj[0];

        String name = jobApplicant.getName();
        String email = jobApplicant.getEmail();
        String skills = jobApplicant.getSkills();
        String resume = jobApplicant.getResumeText();

        if(name == null || email == null || skills == null || resume == null )
            throw new ValidationException("Some required fields are not filled");

        if(resume.length() > 30)
            throw new ValidationException("Resume size is too Large");

    }

    @AfterThrowing(
            pointcut = "forUploadResume()",
            throwing = "ex"
    )
    public void failedUploadResume(JoinPoint joinPoint, Throwable ex){
        LOGGER.error("Error occur : "+ joinPoint.getSignature().getName());
        LOGGER.error(String.valueOf(ex));
    }

}
