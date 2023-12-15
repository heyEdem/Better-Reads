package com.edem.LibraryManagementSystem.Controller;

import com.edem.LibraryManagementSystem.Service.AuthorService;
import com.edem.LibraryManagementSystem.entity.Author;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAuthors(){
        return new ResponseEntity<List<Author>>(authorService.findAllAuthors(),FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return new ResponseEntity<Author>( authorService.createAuthor(author), CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> findAuthor(@PathVariable("id") Long id){
        return new ResponseEntity<Optional<Author>>(authorService.findAuthorById(id), FOUND);
    }

    @GetMapping("/search/{lastName}")
    public ResponseEntity<List<Author>> searchAuthor(@PathVariable("lastName") String lastName){
        return new ResponseEntity<List<Author>>(authorService.findAuthorByName(lastName),FOUND);
    }
}
