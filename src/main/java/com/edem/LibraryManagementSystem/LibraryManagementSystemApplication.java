package com.edem.LibraryManagementSystem;

import java.util.List;
import com.edem.LibraryManagementSystem.Service.BookService;
import com.edem.LibraryManagementSystem.entity.Book;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LibraryManagementSystemApplication /*implements ApplicationRunner*/ {


	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}


//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//
//		List<Book> books = bookService.findAllBooks();
//
//		if (books != null && books.isEmpty()) {
//
//			Book book1 = Book.builder().title("Book1").author("Josh Long").description("Description").price(214.5)
//					.build();
//			Book book2 = Book.builder().title("Book2").author("Hannan Gambit").description("Description").price(11.8)
//					.build();
//			Book book3 = Book.builder().title("Book3").author("Elvis Ennumh").description("Description").price(21.7)
//					.build();
//			Book book4 = Book.builder().title("Book4").author("Emefa Diana").description("Description").price(3.99)
//					.build();
//
//			Arrays.asList(book1, book2, book3).forEach(b -> bookService.createBook(b));
//
//			System.out.println("New books added in database");
//		}
//	}

}
