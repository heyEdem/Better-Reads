package com.edem.LibraryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private double price;

    private BigInteger likes;

    private LocalDateTime uploadedAt;
    @ManyToOne @JsonIgnore
    @JoinColumn(name = "author_id")
    private Author author;

    public void likeBook(){
        this.likes = this.likes.add(BigInteger.valueOf(1));
    }
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Double.compare(book.price, price) == 0 && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(description, book.description) && Objects.equals(likes, book.likes) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, likes, getAuthor());
    }
}
