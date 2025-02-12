package com.livros.literalura.controller;

import com.livros.literalura.model.Author;
import com.livros.literalura.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
	 	@Autowired
		private ConnectAPI ConnectAPI 

	    @GetMapping("/search")
	    public List<Book> searchBooksByTitle(@RequestParam String title) {
	        return ConnectAPI.searchBooksByTitle(title);
	    }

	    @GetMapping
	    public List<Book> listBooks() {
	        return ConnectAPI.listBooks();
	    }

	    @GetMapping("/authors")
	    public List<Author> listAuthors() {
	        return ConnectAPI.listAuthors();
	    }

	    @GetMapping("/authors/year")
	    public List<Author> listAuthorsByYear(@RequestParam int year) {
	        return ConnectAPI.listAuthorsByYear(year);
	    }

	    @GetMapping("/language")
	    public List<Book> listBooksByLanguage(@RequestParam String language) {
	        return ConnectAPI.listBooksByLanguage(language);
	    }
}
