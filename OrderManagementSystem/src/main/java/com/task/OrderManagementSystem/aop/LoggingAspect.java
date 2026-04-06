package com.task.OrderManagementSystem.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution (* com.task.OrderManagementSystem.controller.*.*(..))")
    public void forAllController(){}

    @Pointcut("execution (* com.task.OrderManagementSystem.service.*.*(..))")
    public void forAllService(){}

    @Pointcut("execution (* com.task.OrderManagementSystem.repo.*.*(..))")
    public void forAllRepo(){}

    @Pointcut("execution (* com.task.OrderManagementSystem.exception.*.*(..))")
    public void forAllException(){}

//    @Pointcut("execution (* com.task.OrderManagementSystem.controller.*.*(..))")
//    public void forAllController(){
//
//    }

    // Logging for each method
    @Pointcut("forAllController() || forAllService() || forAllRepo()")
    public void forAllLayers(){

    }


    @Before("forAllLayers()")
    public void logForAllLayers(JoinPoint joinPoint){
        LOGGER.info("Logging Before everything : "+ joinPoint.getSignature().getName());
    }


    /*
        for transaction / payment using AfterReturning & AfterThrowing
     */

    @AfterReturning(
            pointcut = "execution (* com.task.OrderManagementSystem.service.CustomerServiceImpl.payment(..))",
            returning = "result"
    )
    public void forSuccessfulPayment(JoinPoint joinPoint, String result){
        Object[] obj = joinPoint.getArgs();
        LOGGER.info("Payment Done successful for Order : "+ obj[1]);
        LOGGER.info("Result -> "+ result);
    }

    @AfterThrowing(
            pointcut = "execution (* com.task.OrderManagementSystem.service.CustomerServiceImpl.payment(..))",
            throwing = "ex"
    )
    public void forFailedPayment(JoinPoint joinPoint, Throwable ex){
        Object[] obj = joinPoint.getArgs();
        LOGGER.error("Error Occur -> "+ ex);
    }

    /*
        for JobApplicant : After successfully Uploading Resume
     */
    @Pointcut("execution (* com.task.OrderManagementSystem.service.JobApplicantServiceImpl.createJobApplicant(..))")
    public void forUploadResume(){}

    @AfterReturning(
            pointcut = "forUploadResume()"
    )
    public void afterUploadResume(){
        LOGGER.info("Resume Uploaded Successfully");
    }
}
