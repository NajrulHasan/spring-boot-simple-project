package com.springboot.simplespringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.repository.ProductRepository;
import com.springboot.simplespringboot.resonse.ResponseStructure;
import com.springboot.simplespringboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService; 
		
	
	@GetMapping(value = "/getMyData")
	public String getData() {
		
		return "Good Morning India";
		
	}
	
	
	/*
	 * insert product method
	 */
	
	@PostMapping(value = "/insertProduct")
	public Product insertProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
				}
/*
 * insertMultipleProducts
 */
@PostMapping(value = "/insertMultipleProducts")
	public List<Product> insertMultipleProducts(@RequestBody List<Product> products){
		return productService.insertMultipleProducts(products);
		
		
	}

/*
 * deleteProduct
 */
@DeleteMapping(value = "/deleteProduct/{productId}")
public  ResponseStructure<Product> deleteProductById(@PathVariable int productId) {
  return productService.deleteProductById(productId);

}

/*
 * getProductById
 */
@GetMapping(value = "/getProductById/{productId}")
public ResponseStructure<Product> getProductById(@RequestBody int productId) {
	return productService.getProductById(productId);
}

/*
 * update
 */

//@PutMapping("/updateProduct")

}