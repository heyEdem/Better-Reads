package com.edem.LibraryManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.entity.Author;
import com.edem.LibraryManagementSystem.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/{authorId}/save")
    public ResponseEntity<Book> createBook(@PathVariable("authorId") Long authorId, @RequestBody Book book){
        log.info("got book with id {}",book.getId());
         return new ResponseEntity<Book>(bookService.createBook(authorId, book), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> findAllBooks (){
        return new ResponseEntity<List<Book>>(bookService.findAllBooks(),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> findBookById(@PathVariable("id") Long id){
        return new ResponseEntity<Optional<Book>>(bookService.findBookById(id),HttpStatus.FOUND);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Book>> findBookByTitle(@PathVariable("title") String title){
        return new ResponseEntity<List<Book>>(bookService.findBookByTitle(title),HttpStatus.FOUND);
    }

    @GetMapping("/{bookId}/author")
    public ResponseEntity<Author> getBookAuthor(@PathVariable("bookId") Long bookId){
        return new ResponseEntity<Author>(bookService.findBookAuthor(bookId),HttpStatus.FOUND);
    }

}
