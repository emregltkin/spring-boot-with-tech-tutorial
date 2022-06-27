package com.sb.gltkn.controller;

import com.sb.gltkn.model.Book;
import com.sb.gltkn.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize,
                                 @RequestParam Integer page){
        Pageable pageable = PageRequest.of(page, pageSize);
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/pageable")
    public Page<Book> pagination(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/slice")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
