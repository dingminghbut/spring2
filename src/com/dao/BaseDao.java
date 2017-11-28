package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.Configure;


public class BaseDao {
	private Connection connection;
	private PreparedStatement preparedstatement;
	private ResultSet rs;
	//获取连接数据库的方法
	public boolean getConnection(){
		boolean flag = false;
		//加载数据驱动
		try {
			Configure configure = Configure.getInstance();
			String driver = configure.getProperties("driver");
			System.out.println("driver:"+driver);
			Class.forName(driver);
			//获取连接所需要的参数
			String url = configure.getProperties("url");
			String user = configure.getProperties("user");
			String password = configure.getProperties("password");
			//获取连接	
			connection = DriverManager.getConnection(url,user,password);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connection!=null){
			flag=true;
			System.out.println("连接成功");
		}else{
			System.out.println("连接失败");
		}
		return flag;
	}
	//可以使用数据源连接数据库
	//可以做一个测试
//	public static void main(String[] args){
//		BaseDao dao = new BaseDao();
//		dao.getConnection();
//	}
	// 利用PreparedStatement对象进行查询操作,所有的查询，都可以用这个方法
public ResultSet query(String sql ,Object param[]){
		
		try{
			if(getConnection()){
				//获取preparedstatement 的对象
				preparedstatement = connection.prepareStatement(sql);
				for(int i=0;i<param.length;i++){
					preparedstatement.setObject(i+1, param[i]);
				}
				//此处对连接的数据库执行对应的操作
				rs = preparedstatement.executeQuery();
			}			
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	} 
	//此处可以执行添加，修改，删除操作。返回对象原因，不能进行查询操作
	public int update(String sql,Object param[]){
		int total=0;
			try {
			   if(getConnection()){
				preparedstatement = connection.prepareStatement(sql);
				for(int i=0;i<param.length;i++){
					preparedstatement.setObject(i+1, param[i]);
				}
				//此处对连接的数据库执行对应的操作
				total = preparedstatement.executeUpdate();
				} 
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return total;
		}
	public void close(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(preparedstatement!=null){
				preparedstatement.close();
			}
			if(connection!=null){
				connection.close();
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}		
}
