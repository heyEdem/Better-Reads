package com.edem.LibraryManagementSystem.repository;

import com.edem.LibraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findAuthorsByFirstNameContainsIgnoreCase(String firstName);
    List<Author> findAuthorsByLastNameContainsIgnoreCase(String lastName);
}
