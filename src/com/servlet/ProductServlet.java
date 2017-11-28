package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.TakeOut;
import com.pojo.Product;
import com.service.ProductService;
import com.service.TakeOutService;
import com.serviceimpl.TakeOutServiceImpl;
import com.serviceimpl.ProductServiceImpl;

public class ProductServlet extends HttpServlet {
	 ProductService productservice = new ProductServiceImpl();
	 TakeOutService takeoutservice = new TakeOutServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("--------����ProductServlet--------");
			String path = request.getRequestURI();
			System.out.println("path:"+path);
			int index = path.lastIndexOf("/");
			String realpath = path.substring(index+1);
			System.out.println("realpath:"+realpath);
			if(realpath.equals("handin")){
				handin(request,response);
			}if(realpath.equals("reset")){
				reset(request,response);
			}
	}
	
	public void handin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----����handin-----");
		if(check(request,response)){
			System.out.println("---�����ж�����ֵ����---");
			if(compare(request,response)){
				System.out.println("---����ֵ����---");
				TakeOut takeout = new TakeOut();
				
				String productids = request.getParameter("products");
				int productid = Integer.parseInt(productids);
				//takeout��productid
				takeout.setProductid(productid);
				//ͨ��id�ҵ���Ӧ��product
				Product product1 = new Product();
				product1.setId(productid);
				Product product2 = productservice.getProductById(product1);
				//�õ������ֵ�Ĵ�С
				String quantity1 = request.getParameter("quantity");
				int quantity2 = Integer.parseInt(quantity1);
			
				//takeout��quantity
				takeout.setQuantity(quantity2);
				//takeout��handler
				String handler = request.getParameter("handler");
				takeout.setHandler(handler);
				//takeout��ʱ��
				Timestamp date = new Timestamp(System.currentTimeMillis());	
				takeout.setOutdate(date);
				int total = takeoutservice.insertToTakeOut(takeout);
				
				//��product�޸�
				Product product3 = new Product();
				int number = product2.getQuantity()-quantity2;
				product3.setQuantity(number);
				product3.setId(product2.getId());
				product3.setProductname(product2.getProductname());
				int total1 = productservice.updateByProduct(product3);
				
				
				List<Product> list = new ArrayList<Product>();
				list = productservice.getAllProduct();
				request.setAttribute("productlist", list);
				
				String warning5 = "�����ɹ�";
				request.setAttribute("warning5", warning5);
				request.getRequestDispatcher("login.jsp").forward(request, response);				
			}else{
				System.out.println("---����ֵ������---");
				//ͨ��id�ҵ���Ӧ��product
				String productids = request.getParameter("products");
				int productid = Integer.parseInt(productids);
				Product product1 = new Product();
				product1.setId(productid);
				Product product2 = productservice.getProductById(product1);
				String warning4 = "��ѡ��Ʒ��治�㣬��ǰ����Ϊ"+product2.getQuantity();
				request.setAttribute("warning4", warning4);
				List<Product> list = new ArrayList<Product>();
				list = productservice.getAllProduct();
				request.setAttribute("productlist", list);
				//��ԭ���ݱ���ú󴫻�ȥ
				String  handler = request.getParameter("handler");
				String quantity = request.getParameter("quantity"); 
				request.setAttribute("handler", handler);
				request.setAttribute("quantity",quantity);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}else{
			String warning1 = "������Ʒ��ѡ";
			request.setAttribute("warning1", warning1);
			String warning2 = "��������Ϊ����";
			request.setAttribute("warning2", warning2);
			String warning3 = "�����˱���";
			request.setAttribute("warning3", warning3);
			List<Product> list = new ArrayList<Product>();
			list = productservice.getAllProduct();
			request.setAttribute("productlist", list);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	public boolean check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----check-----");
		boolean index=false;
		
		String  products = request.getParameter("products");
		int id = Integer.parseInt(products);
		System.out.println(products);
		
		String quantity = request.getParameter("quantity");
		System.out.println(" products��"+ products);
		//�ж��Ƿ�Ϊ����
		Pattern pattern = Pattern.compile("[0-9]+");    
	    boolean flag2 = pattern.matcher(quantity).matches();
	        	
		String handler = request.getParameter("handler");	
		System.out.println(quantity);
		System.out.println(handler);
		System.out.println(flag2);
		
		if((id!=0)&&(flag2)&&(handler!=null)&&(handler!="")){
			System.out.println("-----���ͨ��-----");
			index = true;
		}else{
			System.out.println("---��鲻ͨ��---");
		}
		return index;
	}
	
	public boolean compare(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----check-----");
		boolean index = false;
		//ͨ��id�ҵ���Ӧ��product
		String productids = request.getParameter("products");
		int productid = Integer.parseInt(productids);
		Product product1 = new Product();
		product1.setId(productid);
		Product product2 = productservice.getProductById(product1);
		//�õ������ֵ�Ĵ�С
		String quantity1 = request.getParameter("quantity");
		int quantity = Integer.parseInt(quantity1);
		
		if(product2.getQuantity()>=quantity){
			System.out.println("��������");
			index = true;
		}else{
			System.out.println("����������");
		}
		return index;
		
	}
	
	
	
	public void reset(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------reset-------");
		List<Product> list = new ArrayList<Product>();
		list = productservice.getAllProduct();
		request.setAttribute("productlist", list);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
