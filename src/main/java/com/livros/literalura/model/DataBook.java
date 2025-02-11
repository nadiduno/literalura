package com.livros.literalura.model;

import java.util.List;
import com.livros.literalura.model.DataAuthor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataBook {
    public String title;
    public List<DataAuthor> authors;
    public List<String> languages;
    public int download_count;

    public DataBook() {} 

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<DataAuthor> getAuthors() { return authors; } 
    public void setAuthors(List<DataAuthor> authors) { this.authors = authors; }

    public List<String> getLanguages() { return languages; } 
    public void setLanguages(List<String> languages) { this.languages = languages; }

    public int getDownload_count() { return download_count; }
    public void setDownload_count(int download_count) { this.download_count = download_count; }
}