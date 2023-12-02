package com.edem.LibraryManagementSystem.Service.impl;

import java.util.List;
import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;
import com.edem.LibraryManagementSystem.repository.AuthorRepository;
import com.edem.LibraryManagementSystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book createorUpdateBook(Book book) {
        return repository.save(book);
    }


    @Override
    public Book createBook(String title, String description, Double price, Long authorId) {
        var author = authorRepository.findById(authorId).orElseThrow(()-> new EntityNotFoundException("Author with id "+authorId+" not found"));
        return repository.save(new Book(title, description, price, author));
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

    @Override
    public Optional<Book> findBookByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> findBookByAuthor(String author) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> findBookAuthor(Long bookId) {
        Optional<Book> result = repository.findById(bookId);
        //noinspection OptionalGetWithoutIsPresent
        return Optional.ofNullable(result.get().getAuthor());
    }


}
