package com.edem.LibraryManagementSystem.Service.impl;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;
import com.edem.LibraryManagementSystem.repository.AuthorRepository;
import com.edem.LibraryManagementSystem.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        log.info("found all");
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Long authorId, Book book) {
        var author = authorRepository.findById(authorId);
        book.setLikes(BigInteger.valueOf(0));
        book.setUploadedAt(LocalDateTime.now());
        book.setAuthor(author.get());
        log.info("{} created at {} ",book.getTitle(), book.getUploadedAt());
        return bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Long id) {
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findBooksByTitleContains(title);
    }


    @Override
    public Author findBookAuthor(Long bookId) {
        var book = bookRepository.findById(bookId);
        return book.get().getAuthor();
    }
}
