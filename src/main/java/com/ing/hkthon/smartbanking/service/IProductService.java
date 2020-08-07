/**
 * 
 */
package com.ing.hkthon.smartbanking.service;

import java.util.List;

import com.ing.hkthon.smartbanking.model.Product;

/**
 * @author pintu
 *
 */
public interface IProductService {

	List<Product> getAllProducts();
	
	Product getProductById(int id);

}
