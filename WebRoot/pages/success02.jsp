<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.pojo.Product,com.pojo.TakeOut" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.back{
	background:yellow;
	}
</style>
</head>
<body>
	<h1>商品出库</h1>
	<form action="search" method="post">
	出库商品：<select name="citynames">
		<%
			List<TakeOut> namelist=(List<TakeOut>)request.getAttribute("namelist");
				for(int i=0;i<namelist.size();i++){
			TakeOut citynames=namelist.get(i);
			out.print(citynames+"<br>");
		%>		
		
		<%
			}
		 %>
		</select><br>
	<input type="submit" values="查询" >
	</form>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>驾校名称</td>
			<td>所在城区</td>
			<td>地址</td>
			<td>联系电话</td>
			<td>操作</td>
		</tr>

        <%int i=0; %>
		<c:forEach var="driverschool" items="${list }">
		    <%request.setAttribute("i", i); %>	
			<tr
			<c:if test="${i%2==0}">
				class = "back"
			</c:if> 
			>
			<td>${driverschool.getName()}</td>
			<td>${driverschool.getDriareaname() }</td>
			<td>${driverschool.getAddress() }</td>
			<td>${driverschool.getPhone() }</td>	
			<td><a href="edit?id=${driverschool.getId() }">修改</a></td>	<br>	
		</tr>	
		<%i++; %>				
		</c:forEach>
				
</body>
</html>