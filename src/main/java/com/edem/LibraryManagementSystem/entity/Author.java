package com.edem.LibraryManagementSystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private Set <Book> books = new HashSet<>();

}
