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
	//��ȡ�������ݿ�ķ���
	public boolean getConnection(){
		boolean flag = false;
		//������������
		try {
			Configure configure = Configure.getInstance();
			String driver = configure.getProperties("driver");
			System.out.println("driver:"+driver);
			Class.forName(driver);
			//��ȡ��������Ҫ�Ĳ���
			String url = configure.getProperties("url");
			String user = configure.getProperties("user");
			String password = configure.getProperties("password");
			//��ȡ����	
			connection = DriverManager.getConnection(url,user,password);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connection!=null){
			flag=true;
			System.out.println("���ӳɹ�");
		}else{
			System.out.println("����ʧ��");
		}
		return flag;
	}
	//����ʹ������Դ�������ݿ�
	//������һ������
//	public static void main(String[] args){
//		BaseDao dao = new BaseDao();
//		dao.getConnection();
//	}
	// ����PreparedStatement������в�ѯ����,���еĲ�ѯ�����������������
public ResultSet query(String sql ,Object param[]){
		
		try{
			if(getConnection()){
				//��ȡpreparedstatement �Ķ���
				preparedstatement = connection.prepareStatement(sql);
				for(int i=0;i<param.length;i++){
					preparedstatement.setObject(i+1, param[i]);
				}
				//�˴������ӵ����ݿ�ִ�ж�Ӧ�Ĳ���
				rs = preparedstatement.executeQuery();
			}			
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	} 
	//�˴�����ִ����ӣ��޸ģ�ɾ�����������ض���ԭ�򣬲��ܽ��в�ѯ����
	public int update(String sql,Object param[]){
		int total=0;
			try {
			   if(getConnection()){
				preparedstatement = connection.prepareStatement(sql);
				for(int i=0;i<param.length;i++){
					preparedstatement.setObject(i+1, param[i]);
				}
				//�˴������ӵ����ݿ�ִ�ж�Ӧ�Ĳ���
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
