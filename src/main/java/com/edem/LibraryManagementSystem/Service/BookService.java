package com.edem.LibraryManagementSystem.Service;

import java.util.List;
import com.edem.LibraryManagementSystem.entity.Book;

import java.util.Optional;


public interface BookService {
    List <Book> findAllBooks();

    Book createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    Optional<Book> findBookById(Long id);

}
