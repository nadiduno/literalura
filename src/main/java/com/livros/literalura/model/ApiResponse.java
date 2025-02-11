package com.livros.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    public int count;
    public String next;
    public String previous;
    public List<DataBook> results;

    public ApiResponse() {}

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    //TODO getters e setters para next, previous e results
}
