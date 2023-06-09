package com.edem.LibraryManagementSystem.Service.impl;

import java.util.List;
import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.entity.Book;
import com.edem.LibraryManagementSystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public void updateBook(Book book) {
         repository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
         repository.deleteById(id);
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return repository.findById(id);
    }
}
