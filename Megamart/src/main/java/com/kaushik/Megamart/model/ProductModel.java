package com.kaushik.Megamart.model;

import java.util.List;

public class ProductModel {
	
	private List<Products> products;

	public Products find(String id) {
		for (Products product : this.products) {
			if (product.getId().equalsIgnoreCase(id)){
				return product;
			}
		}
		return null;
	}
	public List<Products> findAll() {
		return this.products;
	}
}
