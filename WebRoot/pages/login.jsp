<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>商品出库</h1>
	<form action="handin" method="post">
	出库商品：<select name="products">
		<option value="0">--请选择商品--</option>
		<%
			List<Product> namelist=(List<Product>)request.getAttribute("productlist");
				for(int i=0;i<namelist.size();i++){
			Product products=namelist.get(i);
			out.print(products+"<br>");
		%>		
			<option value="<%=products.getId()%>"><%=products.getProductname() %></option>
		<%
			}
		 %>
		</select>${warning1 } <br>
		
		数量：<input type="text" name="quantity" value="${quantity }"> ${warning2 } <br>
		 
		经手人：<input type="text" name="handler" value="${handler }"> ${warning3 } <br>
	<input type="submit" value="提交" >
	</form>
	
	<form action="reset" method="post">
		<input type="submit" value="重置" >
	</form>	
	
	${warning4 } ${warning5 }
	
</body>
</html>