package io.pragra.leanrning.bookservice.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriceReponse {
    private Long id;
    private Long isbn;
    private double price;
}
