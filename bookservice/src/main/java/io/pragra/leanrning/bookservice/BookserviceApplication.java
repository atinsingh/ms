package io.pragra.leanrning.bookservice;

import io.pragra.leanrning.bookservice.domain.Book;
import io.pragra.leanrning.bookservice.service.BookService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication

public class BookserviceApplication {

	@Autowired
	private BookService service;
	public static void main(String[] args) {
		SpringApplication.run(BookserviceApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			this.service.createBook(new Book(1L,"Learning Java","No One",330));
			this.service.createBook(new Book(1L,"Peter Parker","No One",330));
			this.service.createBook(new Book(1L,"Uthopia","No One",330));
			this.service.createBook(new Book(1L,"Test","No One",330));
		};
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
