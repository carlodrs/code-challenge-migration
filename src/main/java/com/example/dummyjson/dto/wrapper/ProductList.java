package com.example.dummyjson.dto.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.example.dummyjson.dto.Product;


/**
 * Classe Wrapper Product para encapsulamento de listas de produtos
 * @author CarlosRenatoDomingos
 * @since 2024
 * 
 * */
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
