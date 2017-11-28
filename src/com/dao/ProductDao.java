package com.dao;

import java.util.List;

import com.pojo.Product;


public interface ProductDao {
	//��ѯ���в�Ʒ
	public List<Product> getAllProduct();
	//��ѯָ��������Ʒ
	public Product getProductByProductName(Product product);
	//����ID��ѯָ���ļ�У
	public Product getProductById(Product product);
	//�޸Ĳ�Ʒ��Ϣ
	public int updateByProduct(Product product);
	
}
