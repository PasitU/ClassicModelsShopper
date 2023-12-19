package com.example.uuuoooohohohoho.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "orderdetails")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orderdetail {
    @Id
    private String orderNumber;
    @Id
    private String productCode;
    private Integer quantityOrdered;
    private Double priceEach;
    private String orderLineNumber;
}
