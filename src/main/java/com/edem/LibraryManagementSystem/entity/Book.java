package com.edem.LibraryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String genre;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    private Author author;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getDescription(), book.getDescription()) && Objects.equals(getPrice(), book.getPrice()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getCreatedAt(), book.getCreatedAt()) && Objects.equals(getUpdatedAt(), book.getUpdatedAt()) && Objects.equals(getDeletedAt(), book.getDeletedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getPrice(), getAuthor(), getCreatedAt(), getUpdatedAt(), getDeletedAt());
    }
}