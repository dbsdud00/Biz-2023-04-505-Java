package com.callor.shop.service;

import java.util.List;

import com.callor.shop.models.ProductDto;

public interface ProductService {

	public List<ProductDto> productList();
	public void productUpdate();
	
}
