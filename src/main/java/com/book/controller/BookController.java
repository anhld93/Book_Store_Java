package com.book.controller;

import com.book.model.Book;
import com.book.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<Object> getAllBooks() {
        List<Book> books = new ArrayList<>();

        books = bookService.getAll();

        return ok(books);
    }
}
