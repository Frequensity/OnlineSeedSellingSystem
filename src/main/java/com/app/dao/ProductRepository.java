package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	@Modifying
	@Query("update Product p set p.price=?1 , p.quantity=?2 where p.id=?3")
	int updateProductById(double price,int quantity,int id);
}
