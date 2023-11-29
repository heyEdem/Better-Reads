package com.edem.LibraryManagementSystem.Service.impl;

import com.edem.LibraryManagementSystem.Service.AuthorService;
import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;
import com.edem.LibraryManagementSystem.repository.AuthorRepository;
import com.edem.LibraryManagementSystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository repository;
    private BookRepository bookRepository;

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

    @Override
    public int bookCount(Author author) {
//        var bookCount = new ArrayList<>();

//        for (Book book: bookRepository.findAll())
//            if(book.getAuthor().getId() == authorId) bookCount.add(book);
//
//        return bookCount.size();
        var bookCount = repository.findAuthorBooks(author);
        return bookCount.get().size();
    }

    public Set<Book> findAuthorBooks(Long authorId){
        Optional<Author> author = repository.findById(authorId);
        Set<Book> list = author.get().getBooks();
        return  list;
    }
}
