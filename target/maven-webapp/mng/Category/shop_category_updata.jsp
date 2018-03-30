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
	<form action="Categoty_Updata"   method="post" >
		<table border="box"  width="400px" height="400px" align="center">
						<tr>
				<td>类别id</td>
				<td><input type="text" name="id"  placeholder="请输入商品id" readonly="readonly"  value="${category.id}"></td>
			</tr>
			<tr>
				<td>分类id</td>
				<td>
				<input type="text" name="parent_id"  placeholder="请输入商品id"  value="${category.parent_id}">
				</td>
			</tr>
			<tr>
				<td>类别名称</td>
				<td><input type="text" name="name"  placeholder="请输入商品"  value="${category.name}" ></td>
			</tr>
			<tr>
				<td>类别状态</td>
				<td>
					<select name="status">
						<option value="${category.status}">${category.status}</option>
						<option value="1">1</option>
						<option value="2">2</option>
						</select>
				</td>
			</tr>
			<tr>
				<td>排序编号</td>
				<td><input type="text" name="sort_order"  placeholder="请输入排序编号" value="${category.sort_order}" ></td>
			</tr>
		</table>
				<input type="submit"  value="修改">
				</form>
				<p></p>
				<a href="Categoty_Servlet?pageNo=1"><input type="button" value="取消" ></a>
	
</body>
</html>