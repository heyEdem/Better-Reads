package com.edem.LibraryManagementSystem.entity;

import lombok.*;

import javax.persistence.*;
import javax.swing.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id", referencedColumnName ="id" )
    private Author author;

    private String description;

    private int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
