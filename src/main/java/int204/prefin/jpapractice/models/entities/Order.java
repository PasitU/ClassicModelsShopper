package com.example.uuuoooohohohoho.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private String orderNumber;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private String status;
    private String comments;
    private String customerNumber;
    @ManyToOne
    @JoinColumn(name = "customerNumber", insertable = false, updatable = false)
    private Customer customer;
}
