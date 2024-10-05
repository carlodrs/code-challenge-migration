package com.example.dummyjson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.wrapper.ProductList;
import com.example.dummyjson.service.ProductService;

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
     *@return {@link ProductList}
     */
    @GetMapping
    public ProductList getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Metodo utilizado para recuperar o produto pelo seu identificador
     * 
     * @param Long id do produto
     * @return {@link Product}
     */
   
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable @Nonnull Long id) {
        return productService.getProductById(id);
    }
}
