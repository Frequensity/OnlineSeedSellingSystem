package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart extends BaseEntity {
	private double price;
	private int productQuantity;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",nullable = false)
	@MapsId
	private User user;
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;
}
