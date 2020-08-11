/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductServiceImplTest.java
 */
package com.ing.hkthon.smartbanking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.ing.hkthon.smartbanking.model.Product;
import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.repository.IProductDao;

/**
 * The Class ProductServiceImplTest.
 */
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	@Mock
	private IProductDao productDao;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;


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
	 * testFindAllProductGroupSuccess
	 */
	@Test
	public void testFindAllProductGroupSuccess() {

		Mockito.when(productDao.findByProductGroup_ProductGroupId(1)).thenReturn(products);

		ResponseEntity<List<Product>> expected = productServiceImpl.getAllProductsByProductGroupId(1);

		Assertions.assertEquals(expected, ResponseEntity.ok(products));
	}
	
	/**
	 * testFindAllProductGroupFailure
	 */
	@Test
	public void testFindAllProductGroupFailure() {

		Mockito.when(productDao.findByProductGroup_ProductGroupId(1)).thenReturn(null);

		ResponseEntity<List<Product>> expected = productServiceImpl.getAllProductsByProductGroupId(1);

		Assertions.assertNotSame(ResponseEntity.noContent(), ResponseEntity.ok(products));
	}
	
	/**
	 * Test find all product no content found.
	 */
	@Test
	public void testFindAllProductNoContentFound() {

		Mockito.when(productDao.findByProductGroup_ProductGroupId(1)).thenReturn(products);

		ResponseEntity<List<Product>> expected = productServiceImpl.getAllProductsByProductGroupId(1);

		Assertions.assertNotSame(expected, ResponseEntity.noContent().build());
	}
	
	/**
	 * Test find product by product id success.
	 */
	@Test
	public void testFindProductByProductIdSuccess() {

		Mockito.when(productDao.findById(1)).thenReturn(Optional.of(product));

		ResponseEntity<Product> expected = productServiceImpl.findProductByProductId(1);

		Assertions.assertEquals(expected, ResponseEntity.ok(product));
	}
	
	/**
	 * Test find product by product id no content.
	 */
	@Test
	public void testFindProductByProductIdFailure() {

		Mockito.when(productDao.findById(1)).thenReturn(Optional.of(product));

		ResponseEntity<Product> expected = productServiceImpl.findProductByProductId(1);

		Assertions.assertNotSame(expected, ResponseEntity.noContent().build());
	}
	
	@Test
	public void testFindProductByProductIdNoContent() {

		Mockito.when(productDao.findById(1)).thenReturn(Optional.empty());

		ResponseEntity<Product> expected = productServiceImpl.findProductByProductId(1);

		Assertions.assertEquals(ResponseEntity.noContent().build(), ResponseEntity.noContent().build());
	}

}
