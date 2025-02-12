package com.livros.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private Integer birthYear;
	    private Integer deathYear;

	    @OneToMany(mappedBy = "author")
	    private List<Book> books;

}
