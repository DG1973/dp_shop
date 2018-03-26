<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>购物车管理</h1>
			<table border=1px  cellspacing="0" cellpadding="0" style="width:90%" align="center">
			<tr>
				<th>用户名</th>	
				<th>商品名称</th>	
				<th>商品类型</th>	
				<th>商品单价</th>	
				<th>商品数量</th>	
				<th>是否选中</th>	
				<th>小计</th>	
				<th>创建时间</th>
				<th>更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageModel.data}" var="cart">
			<tr>
				<td>${cart.user.username}</td>
				<td>${cart.product.name}</td>
				<td>${cart.category.name}</td>
				<td>${cart.price}</td>
				<td>${cart.quantity}</td>
				<td>${cart.checked}</td>
				<td>${cart.payment}</td>
				<td>${cart.create_time}</td>
				<td>${cart.update_time}</td>
				
				<td>
					<a href="Address_Updata?id=${address.id}&userid=${address.user_id}">修改</a>
					<a href="Address_delete?id=${address.id}&userid=${address.user_id}">删除</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		   	<p></p>
    		<p></p>
		<div>
			<c:forEach  var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">		     
		      <a href="Cart_Servlet?pageNo=${pageNo}&pageSize=2&operation=1 ">${pageNo}</a>&nbsp
		      
		    </c:forEach>
    </div>
    <p></p>
<h4>总数为：${sum} </h4>
</body>
</html>