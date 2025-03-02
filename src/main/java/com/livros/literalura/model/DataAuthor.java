package com.livros.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataAuthor {
    public String name;
    public Integer birth_year;
    public Integer death_year;

    public DataAuthor() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }
}