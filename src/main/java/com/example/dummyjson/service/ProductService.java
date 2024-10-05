package com.example.dummyjson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.wrapper.ProductList;


/**
 * 
 * Classe de servico responsavel
 * pelas transacoes e chamadas da 
 * API dummyJson Products
 * 
 * @since 2025
 * @serial 2.0
 * */
@Service
public class ProductService {

    @Autowired
	private WebClient.Builder webClientBuilder;
    
    /* URL dummyJson - product - see yaml file */
	@Value("${url}")
	private String baseUrl;

	
	/**
	 * Metodo para listagem de produtos
	 * @return ProductList
	 * 
	 * */
    public ProductList getAllProducts() {
    	 return webClientBuilder.build()
    			 .get()
    			 .uri(baseUrl)
    			 .retrieve()
    			 .bodyToMono(ProductList.class)
    			 .block();	 
     }

    /**
	 * Metodo para recuperacao de um produto especifico 
	 * @param Long  Id do produto
	 * @return Product
	 * 
	 * */
    public Product getProductById(Long id) {
    	return webClientBuilder.build()
    			 .get()
    			 .uri(baseUrl + "/" + id)
    			 .retrieve()
    			 .bodyToMono(Product.class)
    			 .block();	 
    }
}
