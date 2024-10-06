package com.example.dummyjson.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.wrapper.ProductListWrapper;

@SpringBootTest
public class ProductServiceTest {

	    @Autowired
	    private WebClient.Builder webClientBuilder;

	    @Value("${url}")
	    private String url;
	    
	    private WebClient webClient;
	    
	    @BeforeEach
	    void init() {
	    	webClient =  webClientBuilder.baseUrl(url).build();
	    }
	    
	    @Test
	    public void testProductPriceApiDummyJson() {
	    
	    	Integer productId = 1;
	        Product product = webClient.get()
	          .uri(url + "/" + productId)
	          .retrieve()
	          .bodyToMono(Product.class)
	          .block();

	        assertNotNull(product);
	        assertEquals(1, product.getId());
	        assertEquals(9.99, product.getPrice());
	    }

	    @Test
	    public void testWebClientResponseException() {
	    	
	    
	        WebClientResponseException exception = assertThrows(WebClientResponseException.class, () -> {
	            webClient.get()
	              .uri(url + "wrongURL")
	              .retrieve()
	              .bodyToMono(ProductListWrapper.class)
	              .block();
	        });

	        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
	    }
	    
}
