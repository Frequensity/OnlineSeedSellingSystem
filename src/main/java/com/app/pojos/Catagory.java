package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "catagory")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Catagory extends BaseEntity {
	@Column(length = 20,nullable = false,unique = true)
	private String catagoryName;
	
	public Catagory (String catagoryName) {
		this.catagoryName = catagoryName;
	}
	
	@OneToMany(mappedBy = "catagoryId",cascade = CascadeType.ALL,orphanRemoval = true )
	private List<Product> products = new ArrayList<>();//initializing empty array list 
	
	public void addProduct(Product p) {
		//to add product reference in category
		products.add(p);
		//assign category reference to product
		p.setCatagoryId(this);
		
	}
	
	public void removeProduct(Product p) {
		// remove 
		products.remove(p);
		//assign category reference to product
		p.setCatagoryId(null);
		
	}
	
}
