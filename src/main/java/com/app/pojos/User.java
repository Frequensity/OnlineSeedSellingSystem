package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends BaseEntity {
	@Column(name = "first_name",length = 30)
	private String firstName;
	@Column(name = "last_name",length = 30)
	private String lastName;
	@Column( unique = true)
	private String email;
	private String password;
	@Transient
	private String confirmPassword;
	@Column(length = 20,name = "phone")
	private String phoneNumber;
	@Enumerated(EnumType.STRING)
	private Role type;
	
}
