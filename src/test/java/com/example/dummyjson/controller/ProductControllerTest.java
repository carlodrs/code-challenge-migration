package com.example.dummyjson.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.dummyjson.dto.Product;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest 
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@AutoConfigureJsonTesters
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private JacksonTester<Product> productJsonInput;
	
	@Test
    @Order(1)
    public void testUsingJsonReturn() throws Exception {

        Long expectId = 1l;
    	String expectedTitle = "Essence Mascara Lash Princess";
    	String expectedDescription = "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.";
    	Double expectedPrice = 9.99;
    	String expectedCategory = "beauty";
    	Integer stock = 5;
    	Double rating = 4.94;
    	String[] tags = {  "beauty",  "mascara"};
    	
    	Product product = new Product();
    	product.setId(expectId);
    	product.setTitle(expectedTitle);
    	product.setDescription(expectedDescription);
    	product.setPrice(expectedPrice);
    	product.setCategory(expectedCategory);
    	product.setStock(stock);
    	product.setRating(rating);
    	product.setTags(tags);
    	
    	MvcResult mvcResult = mockMvc.perform(get("/api/products/1")
    			.accept(MediaType.APPLICATION_JSON)
    			.content(productJsonInput.write(product).getJson()))
                .andReturn();
    	
    	assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	    
	 
    @Test
    @Order(2)
    public void testGetAllProducts() throws Exception {
    	MvcResult result = mockMvc.perform(get("/api/products")).andReturn();
    	assertEquals(200, result.getResponse().getStatus());
    }
    
    @Test
    @Order(3)
    public void testSpecificProduct() throws Exception {

        Integer expectId = 1;
    	String expectedTitle = "Essence Mascara Lash Princess";
    	String expectedDescription = "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.";
    	Double expectedPrice = 9.99;
    	
    	MvcResult mvcResult = mockMvc.perform(get("/api/products/1")
    			.accept(MediaType.APPLICATION_JSON))
                .andReturn();
    	
    	String response = mvcResult.getResponse().getContentAsString();
    
    	assertEquals(expectId, JsonPath.parse(response).read("$.id"));
    	assertEquals(expectedTitle, JsonPath.parse(response).read("$.title"));
    	assertEquals(expectedDescription, JsonPath.parse(response).read("$.description"));
    	assertEquals(expectedPrice, JsonPath.parse(response).read("$.price"));    	
    }
    
   
    
}
