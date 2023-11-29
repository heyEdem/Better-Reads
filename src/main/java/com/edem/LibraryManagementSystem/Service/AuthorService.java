package com.edem.LibraryManagementSystem.Service;

import com.edem.LibraryManagementSystem.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor (Author author);
    List<Author> findAllAuthors();
    void updateAuthor(Author author);
    void deleteAuthor(Long authorId);
    Optional<Author> findAuthorById(Long authorId);
    Optional<Author> findAuthorByName(String name);

    int bookCount(Author author);
}
