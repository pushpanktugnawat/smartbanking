package com.ing.hkthon.smartbanking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

import com.ing.hkthon.smartbanking.model.ProductGroup;
import com.ing.hkthon.smartbanking.service.IProductGroupService;

@WebMvcTest(controllers = ProductGroupRestImpl.class)
@ActiveProfiles("test")
public class ProductGroupRestImplTest {

	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductGroupService productGroupService;

   
    /** The staff members. */
	private List<ProductGroup> productGroups;       

	/**
	 * Sets the up.
	 */
	@BeforeEach                           
	void setUp() {                               

		this.productGroups = new ArrayList<>();    
		this.productGroups.add(new ProductGroup(1, "Saving"));
		this.productGroups.add(new ProductGroup(2, "Betalen"));
		this.productGroups.add(new ProductGroup(3, "Hypotheek"));
		
	}
	
	/**
	 * @throws Exception
	 */
	@Test
    @Tag("testGetAllProductGroupsSuccess")
    void testGetAllProductGroupsSuccess() throws Exception {

    	Mockito.when(productGroupService.getAllProductGroup()).thenReturn(ResponseEntity.ok(this.productGroups));
    	mockMvc.perform(get("/api/productGroup")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(this.productGroups.size()));
    }
	
	/**
	 * @throws Exception
	 */
	@Test
    @Tag("testGetAllProductGroupsNoContent")
    void testGetAllProductGroupsNoContent() throws Exception {

    	Mockito.when(productGroupService.getAllProductGroup()).thenReturn(ResponseEntity.noContent().build());
    	mockMvc.perform(get("/api/productGroup")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
    }
}
