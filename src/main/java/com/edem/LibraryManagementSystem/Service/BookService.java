package com.edem.LibraryManagementSystem.Service;

import java.util.List;

import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;

import java.util.Optional;


public interface BookService {
    List <Book> findAllBooks();

    Book createorUpdateBook(Book book);

//    Book makeBook(Long )

    Book createBook(String title, String description,Double price, Long authorId);

    void updateBook(Book book);

    void deleteBook(Long id);

    Optional<Book> findBookById(Long id);

    Optional<Book> findBookByTitle(String title);
    Optional<Book> findBookByAuthor(String author);
    Optional<Author> findBookAuthor(Long bookId);
}
