package com.israel.bookstoremanager.controller;

import com.israel.bookstoremanager.dto.MessageResponseDTO;
import com.israel.bookstoremanager.entity.Author;
import com.israel.bookstoremanager.entity.Book;
import com.israel.bookstoremanager.repository.BookRepository;
import com.israel.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookRepository bookRepository;

    private final BookService bookService;

    @Autowired
    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book){
        return bookService.create(book);
    }

}
