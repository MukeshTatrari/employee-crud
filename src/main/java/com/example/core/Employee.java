package com.example.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Employee implements greeting{

    @Autowired
    Test test;

    @Override
    public void greet() {
        log.info("Welcome Employee :: ");
    }
}
