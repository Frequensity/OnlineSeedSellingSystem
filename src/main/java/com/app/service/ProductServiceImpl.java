package com.app.service;

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
	public Product addproduct(Product transientProduct) {
			
		return productRepo.save(transientProduct);
	}

}
