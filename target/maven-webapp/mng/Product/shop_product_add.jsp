<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center">
<h1 style="margin-top: 50px">添加商品信息</h1>
	<form action="Product_Add"   method="post" >
		<table border="box"  width="400px" height="400px" align="center">

			<tr>
				<td>分类名称</td>
				<td>
						<select name="category_id">
						<c:forEach items="${category}" var="category">
						<option value="${category.id}">${category.name}</option>
						</c:forEach>
						</select>
				</td>
			</tr>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name"  placeholder="请输入商品"></td>
			</tr>
			<tr>
				<td>商品副标题</td>
				<td><input type="text" name="subtitle"  placeholder="请输入商品副标题"></td>
			</tr>
			<tr>
				<td>商品主图</td>
				<td><input type="text" name="main_image"  placeholder="请输入职务"></td>
			</tr>
			<tr>
				<td>图片地址</td>
				<td><input type="text" name="sub_images"  placeholder="请输入职务"></td>
			</tr>
			<tr>
				<td>商品详情	</td>
				<td><input type="text" name="detail"  placeholder="请输入商品详情"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"  placeholder="请输入商品价格"></td>
			</tr>
			<tr>
				<td>库存数量</td>
				<td><input type="text" name="stock"  placeholder="请输入库存数量	"></td>
			</tr>
			<tr>
				<td>在线状态</td>
				<td>
					<select name="status">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						</select>
				</td>
			</tr>
		</table>
				<input type="submit"  value="添加">
				</form>
				<p></p>
				<a href="Product_Servlet?pageNo=1"><input type="button" value="取消" ></a>
	
</body>
</html>