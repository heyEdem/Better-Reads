package com.edem.LibraryManagementSystem.Service.impl;

import com.edem.LibraryManagementSystem.Service.AuthorService;
import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;
//import com.edem.LibraryManagementSystem.entity.User;
import com.edem.LibraryManagementSystem.repository.AuthorRepository;
import com.edem.LibraryManagementSystem.repository.BookRepository;
//import com.edem.LibraryManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository repository;
    private BookRepository bookRepository;
//    private final UserRepository userRepository;

    public AuthorServiceImpl(AuthorRepository repository, BookRepository bookRepository /*UserRepository userRepository*/) {
        this.repository = repository;
        this.bookRepository = bookRepository;
//        this.userRepository = userRepository;
    }

    @Override
    public Author createOrUpdateAuthor(Author author) {
        return repository.save(author);

    }

    @Override
    public Author createAuthor(String name, String description /* Long userId*/) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        return repository.save(new Author(name, description /*user*/));
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

    @Override
    public int bookCount(Author author) {
        return 0;
    }

    public Set<Book> findAuthorBooks(Long authorId){
        Optional<Author> author = repository.findById(authorId);
        Set<Book> list = author.get().getBooks();
        int bookCount = list.size();
        return  list;
    }
}
