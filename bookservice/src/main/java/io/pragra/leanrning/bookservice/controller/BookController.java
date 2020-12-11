package io.pragra.leanrning.bookservice.controller;

import io.pragra.leanrning.bookservice.domain.Book;
import io.pragra.leanrning.bookservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private BookService service;

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return this.service.createBook(book);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.service.getBooks();
    }
}
