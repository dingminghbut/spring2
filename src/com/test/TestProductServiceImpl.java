package com.test;

import java.util.List;

import com.pojo.Product;

import com.service.ProductService;
import com.serviceimpl.ProductServiceImpl;

public class TestProductServiceImpl {

	public static void main(String[] args) {
		ProductService productservice = new ProductServiceImpl();
		List<Product> list= productservice.getAllProduct();
		System.out.println(list);
		
		Product product2 = new Product();
		product2.setProductname("Î÷¹Ï");
		Product product3 = productservice.getProductByProductName(product2);
		System.out.println(product3);
		
		Product product4 = new Product();
		product4.setId(2);
		Product product5 = productservice.getProductById(product4);
		System.out.println(product5);
		
		Product product6 = new Product();
		
		product6.setId(6);
		product6.setProductname("¹þÃÜ¹Ï");
		product6.setQuantity(20);
		
		int total = productservice.updateByProduct(product6);
		System.out.println(total);
		
	}

}
