package com.edem.LibraryManagementSystem.Controller;


import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;
import com.edem.LibraryManagementSystem.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookRestController {

    private final BookService bookService;
    private final AuthorRepository authorRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook (String title, String description, Double price, Long authorId){
        Book book = bookService.createBook(title, description, price, authorId);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book book){
        bookService.updateBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{bookId}/author")
    public Optional<Author> getBookAuthor(@PathVariable("bookId") Long bookId){
        return bookService.findBookAuthor(bookId);
    }
}
