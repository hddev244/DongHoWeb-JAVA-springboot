package com.hddev244.model;

import java.util.ArrayList;
import java.util.List;

public class InitData {

	public static List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		List<Brand> brands = new ArrayList<>();

		brands.add(new Brand(1, "Armin Strom"));
		brands.add(new Brand(2, "Ball Watch"));
		brands.add(new Brand(3, "Chanel"));
		brands.add(new Brand(4, "Girard-Perregaux"));

		products.add(new Product(1, "Classico 1", 7070000.0, 100, "/images/products/product-01.png", brands.get(0),
				Product.WOMAN));
		products.add(new Product(2, "Classico 2", 2500000.0, 100, "/images/products/product-02.png", brands.get(1),
				Product.WOMAN));
		products.add(new Product(3, "Classico 3", 400000.0, 100, "/images/products/product-03.png", brands.get(2),
				Product.MAN));
		products.add(new Product(4, "Classico 4", 5400000.0, 100, "/images/products/product-04.png", brands.get(3),
				Product.WOMAN));
		products.add(new Product(5, "Classico 5", 9900000.0, 100, "/images/products/product-05.png", brands.get(2),
				Product.MAN));
		products.add(new Product(6, "Classico 6", 770000.0, 100, "/images/products/product-06.png", brands.get(3),
				Product.WOMAN));
		products.add(new Product(7, "Smart Watch 1", 880000.0, 100, "/images/products/product-01.png", brands.get(1),
				Product.MAN));
		products.add(new Product(8, "Smart Watch 2", 1270000.0, 100, "/images/products/product-02.png", brands.get(0),
				Product.WOMAN));
		products.add(new Product(9, "Smart Watch 3", 720000.0, 100, "/images/products/product-05.png", brands.get(2),
				Product.WOMAN));
		products.add(new Product(10, "Smart Watch 4", 1700000.0, 100, "/images/products/product-03.png", brands.get(3),
				Product.WOMAN));
		products.add(new Product(11, "Smart Watch 5", 2000000.0, 100, "/images/products/product-06.png", brands.get(0),
				Product.MAN));
		products.add(new Product(12, "Smart Watch 6", 780000.0, 100, "/images/products/product-02.png", brands.get(1),
				Product.WOMAN));
		return products;
	}
}
