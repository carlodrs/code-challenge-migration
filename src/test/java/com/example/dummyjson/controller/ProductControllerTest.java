package com.example.dummyjson.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.jayway.jsonpath.JsonPath;

@SpringBootTest 
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testGetAllProducts() throws Exception {
    	MvcResult result = mockMvc.perform(get("/api/products")).andReturn();
    	assertEquals(200, result.getResponse().getStatus());
    }
    
    @Test
    @Order(2)
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
