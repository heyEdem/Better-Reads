package com.edem.LibraryManagementSystem.Controller;


import antlr.collections.List;
import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.Service.impl.BookServiceImpl;
import com.edem.LibraryManagementSystem.entity.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookRestController {
    private BookServiceImpl bookService;

    public BookRestController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String homePage(Model model){
        var books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "index";
    }

    @GetMapping("/{authorId}/add")
    public String getCreateBookPage(@PathVariable("authorId")Long authorId, @RequestBody Book book,Model model){
        model.addAttribute("authorId",authorId);
        model.addAttribute("book",book);
        return "add-edit-book";
    }
    public String createBook(@PathVariable("authorId")Long authorId, @RequestBody Book book, Model model){
        bookService.createBook(authorId,book);
        return "redirect:/index";
    }
}
