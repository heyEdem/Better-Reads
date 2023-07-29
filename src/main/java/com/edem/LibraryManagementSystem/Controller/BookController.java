package com.edem.LibraryManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String getAllBooks(Model model){
        List<Book> books= bookService.findAllBooks();
        model.addAttribute("books",books);
        return "index";
    }

    @GetMapping("/addBook")
    public String addNewBook(Book book) {
        return "add-edit-book";
    }


    @PostMapping("/addBook")
    public String postNewBook(Book book){
        Book result = bookService.createBook(book);
        return "redirect:/";
    }


    @PutMapping
    @RequestMapping({"/edit","edit/{id}"})
    public String editBook (Model model, @PathVariable("id") Optional<Long> id){
        if (id.isPresent()) {
            Optional <Book> book = bookService.findBookById(id.get());
            if (book.isPresent()) {
                model.addAttribute("book",book);
            }
//            else{
//                model.addAttribute("book", new Book());
//            }
        }
        return "add-edit-book";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
