package com.springboot.simplespringboot.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
   ProductRepository productRepository;
	
	
	
 
/*
 * insert product method
 */
	
	public Product insertProduct(Product product) {
		
		return  productRepository.save(product);
		
	}

	
	
	/*
	 * insert multiple product
	 */
	
	public List<Product> insertMultipleProducts(List<Product> products){
		return productRepository.saveAll(products);

			}

	/*
	 * deleteProduct
	 */

	public void deleteProductById(int productId) {
		Optional<Product> optional =productRepository.findById(productId);
		if(optional.isPresent()) {
			productRepository.delete(optional.get());
		}
	}
	
	
	/*
	 * getPtoductById
	 */
	
	public Product getProductById(int productId) {
		Optional<Product> optional=productRepository.findById(productId);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
			
		}
	}
	}
