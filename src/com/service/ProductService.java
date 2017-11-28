package com.service;

import java.util.List;

import com.pojo.Product;
import com.pojo.TakeOut;

public interface ProductService {

	// 查询所有产品
	public List<Product> getAllProduct();

	// 查询指定名称商品
	public Product getProductByProductName(Product product);

	// 根据ID查询指定的驾校
	public Product getProductById(Product product);

	// 修改产品信息
	public int updateByProduct(Product product);

}
