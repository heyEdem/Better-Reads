package com.edem.LibraryManagementSystem.Controller;

import java.util.List;
import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public String getAllBooks(Model model){
        List<Book> books= bookService.findAllBooks();
        model.addAttribute("books",books);
        return "index";
    }
}
