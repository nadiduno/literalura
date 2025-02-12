package com.livros.literalura;

import java.security.Principal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.livros.literalura.model.DataAuthor;
import com.livros.literalura.model.DataBook;
import com.livros.literalura.model.ApiResponse;
import com.livros.literalura.service.ConnectAPI;
import com.livros.literalura.service.ConvertData;

import com.livros.literalura.repository.*;
import com.livros.literalura.principal.*;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Object repositoryauthor;
		Object repository;
		Principal screenMenu = new Principal(repository,repositoryauthor);
	    ((Object) screenMenu).printMenu();
	}
		
}
