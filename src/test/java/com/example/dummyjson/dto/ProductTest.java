package com.example.dummyjson.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    @Test
    public void testGetAndSetter(){


        Long expectId = 1l;
    	String expectedTitle = "Essence Mascara Lash Princess";
    	String expectedDescription = "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.";
    	Double expectedPrice = 9.99;
    	
    	
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Essence Mascara Lash Princess");
        product1.setDescription("The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.");
        product1.setPrice(9.99);

        assertThat(expectId).isEqualTo(product1.getId());
        assertThat(expectedTitle).isEqualTo(product1.getTitle());
        assertThat(expectedDescription).isEqualTo(product1.getDescription());
        assertThat(expectedPrice).isEqualTo(product1.getPrice());
    }
}
