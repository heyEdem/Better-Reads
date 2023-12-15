package com.edem.LibraryManagementSystem.entity;

import lombok.*;


import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private BigInteger likes;

    private LocalDateTime createdAt;

    @ToString.Exclude
    @OneToMany(mappedBy = "author", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(getId(), author.getId()) && Objects.equals(getFirstName(), author.getFirstName()) && Objects.equals(getLastName(), author.getLastName()) && Objects.equals(getLikes(), author.getLikes()) && Objects.equals(getCreatedAt(), author.getCreatedAt()) && Objects.equals(getBooks(), author.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getLikes(), getCreatedAt(), getBooks());
    }
}
