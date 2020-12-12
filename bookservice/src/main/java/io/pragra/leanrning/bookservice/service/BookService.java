package io.pragra.leanrning.bookservice.service;

import io.pragra.leanrning.bookservice.controller.PriceReponse;
import io.pragra.leanrning.bookservice.domain.Book;
import io.pragra.leanrning.bookservice.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class BookService {

    private BookRepo repo;

    private RestTemplate restTemplate;

    public BookService(BookRepo repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    public Book createBook(Book book) {
        return repo.save(book);
    }

    public Book getBookById(Long id) {
        Optional<Book> book = this.repo.findById(id);
        if (book.isPresent() ) {
            PriceReponse forObject = restTemplate.getForObject("http://localhost:9020/price/{isbn}", PriceReponse.class, 10000L);
            book.get().setPrice(forObject.getPrice());
        }
        return book.get();
    }

    public List<Book> getBooks() {
        return repo.findAll();
    }
}
