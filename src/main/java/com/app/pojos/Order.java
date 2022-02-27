//package com.app.pojos;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "order")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Order extends BaseEntity{
//	
//	
//	@Column(length = 10)
//	private int quantity;
//	@Column(length = 10)
//	private double price;
//	@Column(length = 15)
//	private Date orderDate;
//	@OneToOne()
//	@JoinColumn(name = "usr_id",nullable = false)
//	
//	private User user;
//	@ManyToOne
//	@JoinColumn(name = "prod_id",nullable = false)
//	private Product product;
//}
