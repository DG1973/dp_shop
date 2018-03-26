<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电商后台管理系统</title>
	<style>
			tr:nth-child(odd)
			{	background:  -webkit-linear-gradient(top, #F8F8F8 ,	#E8E8E8 );
				background:  -moz-linear-gradient(top, #F8F8F8 ,	#E8E8E8 );
				background:  -o-linear-gradient(top, #F8F8F8 ,	#E8E8E8 );
				background:  -ms-linear-gradient(top, #F8F8F8 ,	#E8E8E8 );
			}
  
	</style>

</head>
<body style="text-align: center" >
<h1>商品信息管理</h1>
			<table border=1px  cellspacing="0" cellpadding="0" style="width:90%" align="center">
			<tr>
				<th>商品id</th>	
				<th>分类id</th>	
				<th>商品名称</th>	
				<th>商品副标题</th>	
				<th>商品主图</th>	
				<th>图片地址</th>	
				<th>商品详情</th>	
				<th>价格</th>	
				<th>库存数量</th>
				<th>商品状态</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageModel.data}" var="shop">
			<tr>
				<td>${shop.id}</td>
				<td>${shop.category_id}</td>
				<td>${shop.name}</td>
				<td>${shop.subtitle}</td>
				<td>${shop.main_image}</td>
				<td>${shop.sub_images}</td>
				<td>${shop.detail}</td>
				<td>${shop.price}</td>
				<td>${shop.stock}</td>
				<td>${shop.status}</td>
				<td>${shop.create_time}</td>
				<td>${shop.update_time}</td>
				
				<td>
					<a href="Product_Updata?id=${shop.id}">修改</a>
					<a href="Product_Del?id=${shop.id}">删除</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		   	<p></p>
    		<p></p>
		<div>
			<c:forEach  var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">		     
		      <a href="Product_Servlet?pageNo=${pageNo}">${pageNo}</a>&nbsp
		      
		    </c:forEach>
    </div>
    <p></p>
    <p></p>
		<a href="Product_Add"><input type="button"  value="添加"/></a>
</body>
</html>