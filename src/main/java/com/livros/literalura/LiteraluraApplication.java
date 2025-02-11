package com.livros.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.livros.literalura.model.DataAuthor;
import com.livros.literalura.model.DataBook;
import com.livros.literalura.model.ApiResponse;
import com.livros.literalura.service.ConnectAPI;
import com.livros.literalura.service.ConvertData;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var connectApi = new ConnectAPI();
		var json = connectApi.getData("https://gutendex.com/books/?search");
		System.out.println(json);
		ConvertData conversor = new ConvertData();
		ApiResponse response = conversor.getData(json);
		if (response != null) {
	        System.out.println("Count: " + response.getCount()); 
	        for (DataBook book : response.results) { 
	            System.out.println("Title: " + book.getTitle());
	            
	            System.out.print("Authors: ["); 
	            if (book.getAuthors() != null) {
	                for (int i = 0; i < book.getAuthors().size(); i++) {
	                    DataAuthor author = book.getAuthors().get(i);
	                    System.out.print(author.getName());
	                    if (author.getBirth_year() != null) {
	                        System.out.print(" (birth year " + author.getBirth_year());
	                        if (author.getDeath_year() != null) {
	                            System.out.print(", death year " + author.getDeath_year() + ")");
	                        } else {
	                            System.out.print(")");
	                        }
	                    }
	                    if (i < book.getAuthors().size() - 1) { 
	                        System.out.print(", ");
	                    }
	                }
	            }
	            System.out.println("]"); 
	            
	            System.out.println("Languages: " + book.getLanguages()); 
	            System.out.println("Downloads: " + book.getDownload_count()); 
	            System.out.println("--------------------");
	        }
	    } else {
	        System.out.println("Falha ao converter dados.");
	    }
	}
	
}
