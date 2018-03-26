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
	<form action="Categoty_Insert"   method="post" >
		<table border="box"  width="400px" height="400px" align="center">

			<tr>
				<td>分类名称</td>
				<td>
				<input type="text" name="parent_id"  placeholder="请输入商品id">
				</td>
			</tr>
			<tr>
				<td>类别名称</td>
				<td><input type="text" name="name"  placeholder="请输入商品"></td>
			</tr>
			<tr>
				<td>类别状态</td>
				<td>
					<select name="status">
						<option value="1">1</option>
						<option value="2">2</option>
						</select>
				</td>
			</tr>
			<tr>
				<td>排序编号</td>
				<td><input type="text" name="sort_order"  placeholder="请输入职务"></td>
			</tr>
		</table>
				<input type="submit"  value="添加">
				</form>
				<p></p>
				<a href="Categoty_Servlet?pageNo=1"><input type="button" value="取消" ></a>
	
</body>
</html>