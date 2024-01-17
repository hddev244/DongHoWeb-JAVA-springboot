package com.hddev244.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	public static Boolean MAN = true, WOMAN = false;
	private Integer id;
	private String name;
	private Double price;
	private Integer quantity;
	private String image;
	private Brand brand;
	private Boolean genderSpecific;
}
