/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductGroupServiceImplTest.java
 */
package com.ing.hkthon.smartbanking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.repository.IProductGroupDao;

@ExtendWith(MockitoExtension.class)
public class ProductGroupServiceImplTest {

	@Mock
	private IProductGroupDao productGroupDao;

	@InjectMocks
	private ProductGroupServiceImpl productGroupServiceImpl;


	private static List<ProductGroup> productGroups; 
	
	@BeforeAll                           
	static void setUp() {                               

		productGroups = new ArrayList<>();    
		productGroups.add(new ProductGroup(1, "Saving"));
		productGroups.add(new ProductGroup(2, "Peter"));
	}

	
	/**
	 * Test get all product group success.
	 */
	@Test
	public void testGetAllProductGroupSuccess() {

		Mockito.when(productGroupDao.findAll()).thenReturn(productGroups);

		ResponseEntity<List<ProductGroup>> expected = productGroupServiceImpl.getAllProductGroup();

		Assertions.assertEquals(expected.getBody(), productGroups);
	}
	
	/**
	 * Test get all product group no content.
	 */
	@Test
	public void testGetAllProductGroupNoContent() {

		Mockito.when(productGroupDao.findAll()).thenReturn(null);

		ResponseEntity<List<ProductGroup>> expected = productGroupServiceImpl.getAllProductGroup();

		Assertions.assertEquals(expected, ResponseEntity.noContent().build());
	}

}
