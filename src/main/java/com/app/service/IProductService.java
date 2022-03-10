package com.app.service;

import java.util.List;

import com.app.pojos.Product;

public interface IProductService {
	String addproduct(Product transientProduct);
	
	List<Product> getAllProducts();
}
