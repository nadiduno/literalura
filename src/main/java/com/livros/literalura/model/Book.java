package com.livros.literalura.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String language;
    private Integer downloads;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public void setAuthor(Author author) {
    }

}
