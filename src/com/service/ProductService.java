package com.service;

import java.util.List;

import com.pojo.Product;
import com.pojo.TakeOut;

public interface ProductService {

	// ��ѯ���в�Ʒ
	public List<Product> getAllProduct();

	// ��ѯָ��������Ʒ
	public Product getProductByProductName(Product product);

	// ����ID��ѯָ���ļ�У
	public Product getProductById(Product product);

	// �޸Ĳ�Ʒ��Ϣ
	public int updateByProduct(Product product);

}
