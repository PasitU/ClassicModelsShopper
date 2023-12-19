package com.example.uuuoooohohohoho.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productlines")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Productline {
    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;
}
