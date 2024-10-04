package com.example.dummyjson.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.wrapper.ProductList;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Essence Mascara Lash Princess");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Eyeshadow Palette with Mirror");
        	
        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        
        ProductList productList = new ProductList();
        productList.setProducts(products);
        
        when(restTemplate.getForObject("https://dummyjson.com/products", ProductList.class)).thenReturn(productList);

        List<Product> result = productService.getAllProducts();
        assertEquals(2, result.size());
        assertEquals("Essence Mascara Lash Princess", result.get(0).getTitle());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Product 1");

        when(restTemplate.getForObject("https://dummyjson.com/products/1", Product.class)).thenReturn(product);

        Product result = productService.getProductById(1L);
        assertEquals("Product 1", result.getTitle());
    }
}
