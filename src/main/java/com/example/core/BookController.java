package com.example.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    public BookController(){
        log.info("creating BookController :: ");
    }


    @GetMapping()
    public String getBookDetails() {

        return bookService.getBookDetails();
    }

    @GetMapping("/db")
    public String getDatabaseDetails() {

        return bookService.getDatabaseDetails();
    }
}
