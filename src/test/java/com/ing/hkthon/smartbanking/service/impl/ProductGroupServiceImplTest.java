package com.ing.hkthon.smartbanking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.repository.IProductGroupDao;

@ExtendWith(MockitoExtension.class)
public class ProductGroupServiceImplTest {

	@Mock
	private IProductGroupDao productGroupDao;

	@InjectMocks
	private ProductGroupServiceImpl productGroupServiceImpl;


	private List<ProductGroup> productGroups; 
	
	@BeforeEach                           
	void setUp() {                               

		this.productGroups = new ArrayList<>();    
		this.productGroups.add(new ProductGroup(1, "Saving"));
		this.productGroups.add(new ProductGroup(2, "Peter"));
	}

	/**
	 * Test find all staff members success.
	 */
	@Test
	public void testFindAllStaffMembersSuccess() {

		Mockito.when(productGroupDao.findAll()).thenReturn(this.productGroups);

		List<ProductGroup> expected = productGroupServiceImpl.getAllProductGroup();

		Assertions.assertEquals(expected, this.productGroups);
	}

}
