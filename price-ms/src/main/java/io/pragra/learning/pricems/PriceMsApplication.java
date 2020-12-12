package io.pragra.learning.pricems;

import io.pragra.learning.pricems.domain.BookPricing;
import io.pragra.learning.pricems.repo.PriceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PriceMsApplication {
    private PriceRepo repo;

    public PriceMsApplication(PriceRepo repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(PriceMsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
            return args -> {
              repo.save(new BookPricing(0L, 10000L, 2000 ));
              repo.save(new BookPricing(0L, 20000L, 2000 ));
              repo.save(new BookPricing(0L, 30000L, 2000 ));
              repo.save(new BookPricing(0L, 40000L, 2000 ));
            };
    }
}
