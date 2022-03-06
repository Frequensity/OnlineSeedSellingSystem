package com.app.dto;

import com.app.pojos.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private Role type = Role.USER;
}
