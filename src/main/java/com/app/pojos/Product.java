package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends BaseEntity {
	@Column(length = 30,nullable = false, name = "product_name")
	private String productName;
	@Column(length = 500)
	private String description;
	@Column(length = 40, nullable = false,name = "catagory_name")
	private String catagoryName;
	@Column(length = 10)
	private double price;
	@Column(length = 10)
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "cat_no",nullable = false)
	private Catagory catagoryId;
	           
}
