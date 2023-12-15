package com.edem.LibraryManagementSystem.Service.impl;

import com.edem.LibraryManagementSystem.Service.AuthorService;
import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.repository.AuthorRepository;
import com.edem.LibraryManagementSystem.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service @Slf4j
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final BookRepository bookRepository;


    public AuthorServiceImpl(AuthorRepository repository, BookRepository bookRepository ) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        author.setCreatedAt(LocalDateTime.now());
        author.setLikes(BigInteger.valueOf(0));
        log.info("new author created");
        return repository.save(author);
    }
    @Override
    public Optional<Author> findAuthorById(Long authorId) {
        var author = repository.findById(authorId);
        author.get().setBooks(bookRepository.findBookByAuthor(author.get()));
        log.info("found author with id {}",author.get().getId());
        return author;
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
    public List<Author> findAuthorByName(String keyword) {
        if (repository.findAuthorsByFirstNameContainsIgnoreCase(keyword).isEmpty())
            return repository.findAuthorsByLastNameContainsIgnoreCase(keyword);
        return repository.findAuthorsByFirstNameContainsIgnoreCase(keyword);
    }

    @Override
    public int bookCount(Author author) {
        return 0;
    }

}
