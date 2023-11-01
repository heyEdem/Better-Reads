package com.edem.LibraryManagementSystem.Service.impl;

import com.edem.LibraryManagementSystem.Service.AuthorService;
import com.edem.LibraryManagementSystem.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public Author createAuthor(Author author) {
        return null;
    }

    @Override
    public List<Author> findAllAuthors() {
        return null;
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteAuthor(Long authorId) {

    }

    @Override
    public Optional<Author> findAuthorById(Long authorId) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> findAuthorByName(String name) {
        return Optional.empty();
    }
}
