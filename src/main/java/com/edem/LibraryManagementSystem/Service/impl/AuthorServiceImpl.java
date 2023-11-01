package com.edem.LibraryManagementSystem.Service.impl;

import com.edem.LibraryManagementSystem.Service.AuthorService;
import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository repository;

    @Override
    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        return repository.findAll();
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteAuthor(Long authorId) {
        repository.findById(authorId).ifPresent(repository::delete);
    }

    @Override
    public Optional<Author> findAuthorById(Long authorId) {
        return repository.findById(authorId);
    }

    @Override
    public Optional<Author> findAuthorByName(String lastName) {
        return Optional.ofNullable(repository.findAuthorByLastName(lastName));
    }
}
