package io.pragra.learning.pricems.controller;

import io.pragra.learning.pricems.domain.BookPricing;
import io.pragra.learning.pricems.repo.PriceRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceContoller {

    private PriceRepo repo;

    public PriceContoller(PriceRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/price/{isbn}")
    public BookPricing getPriceByIsBn(@PathVariable Long isbn) {
        return this.repo.findByIsbn(isbn);
    }
}
