package com.example.dummyjson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.wrapper.ProductList;

@Service
public class ProductService {

	private final String BASE_URL = "https://dummyjson.com/products";

	@Autowired
	private RestTemplate restTemplate;

	public List<Product> getAllProducts() {
		ProductList productList = restTemplate.getForObject(BASE_URL, ProductList.class);
		List<Product> products = productList.getProducts();
		return products;
	}

	public Product getProductById(Long id) {
		String url = BASE_URL + "/" + id;
		return restTemplate.getForObject(url, Product.class);
	}
}
