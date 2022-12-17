package com.example.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    Book book;

    @Autowired
    DatabaseConfig config;

    public String getBookDetails() {

        return "BookName " + book.getName() +
                "  Author of this Book  ::: " + book.getAuthor() + " Price of the book :: " + book.getPrice();
    }

    public String getDatabaseDetails() {

        return "Host " + config.getHost() +
                "  URL of this DB  ::: " + config.getUrl() + " Port of the DB :: " + config.getPort();
    }
}
