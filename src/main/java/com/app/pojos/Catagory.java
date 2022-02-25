package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(length = 20,nullable = false)
	private String catagoryName;
}
