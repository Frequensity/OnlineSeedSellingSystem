package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Catagory;

@Repository
public interface CatagoryRepository extends JpaRepository<Catagory,Integer> {
	
}
