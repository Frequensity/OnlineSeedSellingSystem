package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductRepository;
import com.app.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	
	@Autowired 
	private ProductRepository productRepo;
	@Override
	public String addproduct(Product transientProduct) {
		if(productRepo.save(transientProduct) != null) {
		return "product added succesfully" ;
		}
		return "Cannot add product";
	}
	@Override
	public List<Product> getAllProducts() {
		
		return productRepo.findAll();
	}

}
