package com.livros.literalura.service;

import com.livros.literalura.model.ApiResponse;

public interface IConvertData {
	<T> T  getData(String json, Class<T> classe);
	 ApiResponse getData(String json); 
}
