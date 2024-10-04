package com.example.dummyjson.dto.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.example.dummyjson.dto.Product;

public class ProductList {

	private List<Product> products;

    public ProductList() {
    	products = new ArrayList<>();
    }

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
    
}
