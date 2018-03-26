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
<h1>用户信息管理</h1>
			<table border=1px  cellspacing="0" cellpadding="0" style="width:90%" align="center">
			<tr>
				<th>用户ID</th>	
				<th>用户名</th>	
				<th>密码</th>	
				<th>电子邮箱</th>	
				<th>联系电话</th>	
				<th>密码问题</th>	
				<th>密码答案</th>	
				<th>管理员级别</th>	
				<th>创建时间</th>
				<th>更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageModel.data}" var="user">
			<tr>
				<td>${user.id}</td>
				<td><a href="/dp_shop/Address_Servlet?pageNo=1&userid=${user.id}">${user.username}</a></td>
				<td>${user.password}</td>
				<td>${user.email}</td>
				<td>${user.phone}</td>
				<td>${user.question}</td>
				<td>${user.answer}</td>
				<td>${user.role}</td>
				<td>${user.create_time}</td>
				<td>${user.update_time}</td>
				
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
		      <a href="User_Servlet?pageNo=${pageNo}">${pageNo}</a>&nbsp
		      
		    </c:forEach>
    </div>
</body>
</html>