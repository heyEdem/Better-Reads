package com.edem.LibraryManagementSystem.Service;

import java.util.List;

import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;

import java.util.Optional;


public interface BookService {
    List <Book> findAllBooks();

    Book createBook(Long authorId, Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    void likeBook(Long id);
    Optional<Book> findBookById(Long id);

    List<Book> findBookByTitle(String title);
    Author findBookAuthor(Long bookId);
}
