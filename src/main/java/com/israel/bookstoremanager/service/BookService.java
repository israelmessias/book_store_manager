package com.israel.bookstoremanager.service;

import com.israel.bookstoremanager.dto.MessageResponseDTO;
import com.israel.bookstoremanager.entity.Book;
import com.israel.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@Valid Book book){

        Book savedBook = bookRepository.save(book);
        return  MessageResponseDTO.builder().
                message("Book created with ID  " + savedBook.getId()).
                build();
    }


}
