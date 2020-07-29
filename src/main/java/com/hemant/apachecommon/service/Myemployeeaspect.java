package com.hemant.apachecommon.service;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.hemant.apachecommon.service.CSVWriterService.SAMPLE_CSV_FILE;

@Aspect
@Component
public class Myemployeeaspect {

    @AfterReturning(value= "execution(* com.hemant.apachecommon.controller.CSVController.generateReport(..))",returning= "result")
    public void afterReturningAdvice(JoinPoint joinPoint, ResponseEntity result) throws IOException {
        System.out.println("Inside Around() method...." + " Inserted after= " + joinPoint.getSignature().getName() + " method");
       /* System.out.println(result.getStatusCode());
        System.out.println(HttpStatus.OK);*/
        if(result.getStatusCode()==HttpStatus.OK)
         Files.deleteIfExists(Paths.get(SAMPLE_CSV_FILE));
    }
}