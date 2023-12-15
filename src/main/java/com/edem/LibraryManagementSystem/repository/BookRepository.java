package com.edem.LibraryManagementSystem.repository;

import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
        List<Book> findBooksByTitleContains (String title);
        List<Book> findBookByAuthor (Author author);
}
