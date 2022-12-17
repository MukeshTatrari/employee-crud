package com.example.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class MyController {


    @Autowired
//    @Qualifier("student")
    private greeting greeting;

    @GetMapping("/user")
    public void greetUser() {
        greeting.greet();
    }

}
