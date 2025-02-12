package com.livros.literalura.dataAPI;

import com.livros.literalura.model.ApiResponse;
import com.livros.literalura.model.DataAuthor;
import com.livros.literalura.model.DataBook;
import com.livros.literalura.service.ConnectAPI;
import com.livros.literalura.service.ConvertData;

public class DataAPICommand {
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
	            
	            System.out.println("Summaries:");
	            if (book.getSummaries() != null) {
	                for (String summary : book.getSummaries()) {
	                    System.out.println("  - " + summary);
	                }
	            } else {
	                System.out.println("  Nenhum resumo disponível");
	            }
	            
	            System.out.println("Formats:");
	            if (book.getFormats() != null) {
	                String htmlUrl = book.getFormats().get("text/html");
	                String imageUrl = book.getFormats().get("image/jpeg");

	                if (htmlUrl != null) {
	                    System.out.println("  text/html: " + htmlUrl);
	                } else {
	                    System.out.println("  text/html: não disponível");
	                }

	                if (imageUrl != null) {
	                    System.out.println("  image/jpeg: " + imageUrl);
	                } else {
	                    System.out.println("  image/jpeg: não disponível");
	                }
	            } else {
	                System.out.println("  Nenhum formato disponível");
	            }
	            
	            System.out.println("Languages: " + book.getLanguages()); 
	            System.out.println("Downloads: " + book.getDownload_count()); 
	            System.out.println("--------------------");
	        }
	    } else {
	        System.out.println("Falha ao converter dados.");
	    }
	}

}
