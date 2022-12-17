package com.example.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Service;

@Slf4j
@Lazy
@Service
public class Test {

    public Test(){
        log.info("Test Class Default constructor :::");
    }

    public void greet(){
        log.info("Hello User Welcome  to Test Class ");
    }
}
