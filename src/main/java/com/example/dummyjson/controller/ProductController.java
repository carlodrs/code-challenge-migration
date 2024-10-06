package com.example.dummyjson.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.wrapper.ProductListWrapper;
import com.example.dummyjson.service.ProductService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import jakarta.annotation.Nonnull;

/**
 * Classe responsavel pelas operacoes dos produtos (CRUD)
 * @author CarlosRenatoDomingos
 * @since 2023
 * 
 * */
@RestController
@RequestMapping("/api/products")
public class ProductController {

	
    @Autowired
    private ProductService productService;

    /**
     * Metodo utilizado para listar todos os produtos
     *@return {@link ProductListWrapper}
     * @throws JSONException 
     */
    @GetMapping
    public ResponseEntity<Map<String, List<Product>>> getAllProducts() throws JSONException {
    	ProductListWrapper wrapper = productService.getAllProducts();
    	List<Product> products = wrapper.getProducts();
    	Map<String, List<Product> > map = new  HashMap<>();
    	map.put("products", products);
    	return ResponseEntity.ok()
    	.contentType(MediaType.APPLICATION_JSON)
    	.body(map);
    
    }

    /**
     * Metodo utilizado para recuperar o produto pelo seu identificador
     * 
     * @param Long id do produto
     * @return {@link Product}
     */
   
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable @Nonnull Long id) {
    	Product product = productService.getProductById(id);
    	return ResponseEntity.ok(product);
    }
}
