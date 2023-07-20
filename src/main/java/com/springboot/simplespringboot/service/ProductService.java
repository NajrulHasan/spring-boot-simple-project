package com.springboot.simplespringboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.springboot.simplespringboot.Dao.ProductDao;
import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.resonse.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ResponseStructure<Product> responseStructure;
	
/*
 * insert product method
 */
	
	public Product insertProduct(Product product) {
		if(product.getProductPrice()<=40000) {
			return productDao.insertProduct(product);
			
		}
		else {
			return null;
		}
	}
	
	/*
	 * insertMultipleProducts
	 */
	
	public List<Product> insertMultipleProducts(List<Product> products){
		List<Product> product2=new ArrayList<>();
		for (Product product : products) {
			 
				if(product.getProductPrice()<=40000) {
					product2.add(product);
		
			
		}
				
	}
		return productDao.insertMultipleProducts(products);
	
	}
	
	/*
	 * deleteProduct
	 */
//	
//	public void deleteProductById(int productId) {
//		productDao.deleteProductById(productId);
//}
	
	/*
	 * getProductBYId
	 */
	
	
	public ResponseStructure<Product> getProductById(int productId) {
		Product product=productDao.getProductById(productId);
		if(product!=null) {
			responseStructure.setStatusCode("statusCode: "+ HttpStatus.FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMassage("Given-----id----is present -----success");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}else {
			responseStructure.setStatusCode("statusCode: "+ HttpStatus.NOT_FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMassage("Given-----id----is--not --- present");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		return responseStructure;
	}
	
	
	/*
	 * deleteById
	 */
	
	public ResponseStructure<Product> deleteProductById(int productId) {
		Product product=productDao.getProductById(productId);
		if(product!=null) {
			productDao.deleteProductById(productId);
			responseStructure.setStatusCode("statusCode: "+ HttpStatus.ACCEPTED.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMassage("Data Deleted😊");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}else {
			responseStructure.setStatusCode("statusCode: "+ HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMassage("Given-----id----is--not --- present");
			responseStructure.setDescription("data not delete"+"com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		return responseStructure;
	}
}
