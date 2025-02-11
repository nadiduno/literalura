package com.livros.literalura.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule; 
import org.springframework.stereotype.Service; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.livros.literalura.model.ApiResponse;

@Service
public class ConvertData implements IConvertData { 

    private ObjectMapper mapper = new ObjectMapper();

    public ConvertData() {
        mapper.registerModule(new JavaTimeModule()); 
    }

    @Override
    public ApiResponse getData(String json) { 
        try {
            return mapper.readValue(json, ApiResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // 
        }
    }

    @Override 
    public <T> T getData(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}