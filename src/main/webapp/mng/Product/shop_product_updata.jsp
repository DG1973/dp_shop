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
<h1 style="margin-top: 50px">修改商品信息</h1>
	<form action="Product_Updata"   method="post" >
	
	<table border="box"  width="400px" height="400px" align="center">
						<tr>
				<td>商品名id</td>
				<td><input type="text" name="id"  placeholder="请输入商品id"  value="${product.id }"></td>
			</tr>
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
				<td><input type="text" name="name"  placeholder="请输入商品"  value="${product.name }"></td>
			</tr>
			<tr>
				<td>商品副标题</td>
				<td><input type="text" name="subtitle"  placeholder="请输入商品副标题"  value="${product.subtitle}"></td>
			</tr>
			<tr>
				<td>商品主图</td>
				<td><input type="text" name="main_image"  placeholder="请输入职务"  value="${product.main_image }"></td>
			</tr>
			<tr>
				<td>图片地址</td>
				<td><input type="text" name="sub_images"  placeholder="请输入职务"  value="${product.sub_images }"></td>
			</tr>
			<tr>
				<td>商品详情	</td>
				<td><input type="text" name="detail"  placeholder="请输入商品详情" value="${product.detail }"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"  placeholder="请输入商品价格" value="${product.price}"></td>
			</tr>
			<tr>
				<td>库存数量</td>
				<td><input type="text" name="stock"  placeholder="请输入库存数量	" value="${product.stock}"></td>
			</tr>
			<tr>
				<td>在线状态</td>
				<td>
					<select name="status">
						<option value="${product.status}">${product.status}</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						</select>
				</td>
			</tr>
		</table>
				<input type="submit"  value="修改">
				</form>
				<p></p>
				<a href="Product_Servlet?pageNo=1"><input type="button" value="取消" ></a>
	
</body>
</html>