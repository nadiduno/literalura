package com.livros.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.livros.literalura.service.ConnectAPI;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var connectApi = new ConnectAPI();
		var json = connectApi.obterDados("https://gutendex.com/books/?search=casa+velha");
		System.out.println(json);
		
	}

}
