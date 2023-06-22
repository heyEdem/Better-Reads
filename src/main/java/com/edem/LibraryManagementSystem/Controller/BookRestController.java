//package com.edem.LibraryManagementSystem.Controller;
//
//
//import com.edem.LibraryManagementSystem.Service.BookService;
//import com.edem.LibraryManagementSystem.entity.Book;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/book")
//public class BookRestController {
//
//    private final BookService bookService;
//
//    public BookRestController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Book>> getAllBooks(){
//        List<Book> books = bookService.findAllBooks();
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity <Long> addNewBook(@RequestBody Book book){
//        Book insertedbook = bookService.createBook(book);
//        if(insertedbook == null)
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity (insertedbook.getId(), HttpStatus.OK);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<Book> update(@RequestBody Book book){
//        bookService.updateBook(book);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity delete(@PathVariable("id") Long id){
//        bookService.deleteBook(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
