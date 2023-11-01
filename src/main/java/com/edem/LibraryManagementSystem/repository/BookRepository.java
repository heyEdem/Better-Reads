package com.edem.LibraryManagementSystem.repository;

import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
        Book findBookByTitle (String title);
}
