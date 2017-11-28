package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.pojo.Product;
import com.service.ProductService;
import com.serviceimpl.ProductServiceImpl;

public class LoginFilter implements Filter{
	
	
	@Override
	public void destroy() {	
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("-----���õ�¼������-------");
		ProductService productservice = new ProductServiceImpl();
		List<Product> list = new ArrayList<Product>();
		list = productservice.getAllProduct();
		request.setAttribute("productlist", list);
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
