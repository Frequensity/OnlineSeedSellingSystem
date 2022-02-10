package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Address extends BaseEntity{
	
	@Column(length = 10)
	private int houseNo;
	@Column(length = 50)
	private String street;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	@Column(length = 10)
	private int pincode;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "u_id",nullable = false)
	@MapsId
	private User user;
	
	public Address(int houseNo, String street, String city, String state, int pincode) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
}
