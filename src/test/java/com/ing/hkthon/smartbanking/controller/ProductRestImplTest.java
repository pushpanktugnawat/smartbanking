/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductRestImplTest.java
 */
package com.ing.hkthon.smartbanking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.ing.hkthon.smartbanking.model.Product;
import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.service.IProductService;

/**
 * The Class ProductRestImplTest.
 *
 * @author pintu
 */
@WebMvcTest(controllers = ProductRestImpl.class)
@ActiveProfiles("test")
public class ProductRestImplTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IProductService productService;

	private static List<Product> products; 

	private static Product product;

	@BeforeAll                           
	static void setUp() {                               

		products = new ArrayList<>();

		ProductGroup productGroup=new ProductGroup(1,"Sparen");

		products.add(new Product(1, "Oranjespaarrekening", 2000, 15,productGroup));
		products.add(new Product(2, "Bonusrenterekening", 2000, 15,productGroup));
		products.add(new Product(3, "Spaardeposito", 2000, 15,productGroup));

		product=new Product(1, "Oranjespaarrekening", 2000, 15,productGroup);
	}
	
	
	/**
	 * Test get all products by product group id success.
	 *
	 * @throws Exception the exception
	 */
	@Test
    @Tag("testGetAllProductsByProductGroupIdSuccess")
    void testGetAllProductsByProductGroupIdSuccess() throws Exception {

    	Mockito.when(productService.getAllProductsByProductGroupId(product.getProductGroup().getProductGroupId())).
    	thenReturn(ResponseEntity.ok(this.products));
    	
    	mockMvc.perform(get("/api/products/findByProductGroup/{productGroupId}",1)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(products.size()));
    }
	
	
	/**
	 * Test find by product id success.
	 *
	 * @throws Exception the exception
	 */
	@Test
    @Tag("testFindByProductIdSuccess")
    void testFindByProductIdSuccess() throws Exception {

    	Mockito.when(productService.findProductByProductId(product.getProductGroup().getProductGroupId())).
    	thenReturn(ResponseEntity.ok(product));
    	
    	mockMvc.perform(get("/api/products/{productId}",1)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value(product.getName()));
    }
	
	
	/**
	 * Test get all products by product group id no content.
	 *
	 * @throws Exception the exception
	 */
	@Test
    @Tag("testGetAllProductsByProductGroupIdNoContent")
    void testGetAllProductsByProductGroupIdNoContent() throws Exception {

    	Mockito.when(productService.getAllProductsByProductGroupId(product.getProductGroup().getProductGroupId())).
    	thenReturn(ResponseEntity.noContent().build());
    	
    	mockMvc.perform(get("/api/products/findByProductGroup/{productGroupId}",1)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
    }
	
	
	/**
	 * Test find by product id no content.
	 *
	 * @throws Exception the exception
	 */
	@Test
    @Tag("testFindByProductIdNoContent")
    void testFindByProductIdNoContent() throws Exception {

		Mockito.when(productService.findProductByProductId(product.getProductGroup().getProductGroupId())).
    	thenReturn(ResponseEntity.noContent().build());
    	
    	mockMvc.perform(get("/api/products/{productId}",1)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
    }

}
