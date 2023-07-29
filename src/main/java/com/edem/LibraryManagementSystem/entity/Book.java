package com.edem.LibraryManagementSystem.entity;

import lombok.*;

import javax.persistence.*;
import javax.swing.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

//    @ManyToOne
//    @JoinColumn(name="authors_id", nullable = false)

    private String author;

    private String description;

    private double price;

}
