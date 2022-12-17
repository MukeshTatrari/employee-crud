package com.example.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Primary
@PropertySource("classpath:custom-student.properties")
public class Student implements greeting {

    @Value("${message}")
    private String message;

    @Override
    public void greet() {
        log.info("Welcome Student ::: " + message);
    }

}
