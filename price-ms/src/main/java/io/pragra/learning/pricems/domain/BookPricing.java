package io.pragra.learning.pricems.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class BookPricing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long isbn;

    private double price;


}
