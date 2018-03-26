<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center" >
<h1>用户地址信息管理</h1>
			<table border=1px  cellspacing="0" cellpadding="0" style="width:90%" align="center">
			<tr>
				<th>ID</th>	
				<th>用户ID</th>	
				<th>收货姓名</th>	
				<th>收货固定电话</th>	
				<th>收货移动电话</th>	
				<th>省份</th>	
				<th>城市</th>
				<th>区/县</th>
				<th>详细地址</th>
				<th>邮编</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageModel.data}" var="address">
			<tr>
				<td>${address.id}</td>
				<td>${address.user_id}</td>
				<td>${address.receiver_name}</td>
				<td>${address.receiver_phone}</td>
				<td>${address.receiver_mobile}</td>
				<td>${address.receiver_province}</td>
				<td>${address.receiver_city}</td>
				<td>${address.receiver_district}</td>
				<td>${address.receiver_address}</td>
				<td>${address.receiver_zip}</td>
				<td>${address.create_time}</td>
				<td>${address.update_time}</td>
				
				<td>
					<a href="Address_Updata?id=${address.id}&userid=${address.user_id}&userid=${userid}">修改</a>
					<a href="Address_delete?id=${address.id}&userid=${address.user_id}">删除</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		   	<p></p>
    		<p></p>
		<div>
			<c:forEach  var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">		     
		      <a href="Address_Servlet?pageNo=${pageNo}&userid=${userid}">${pageNo}</a>&nbsp
		      
		    </c:forEach>
    </div>
    <p></p>
    <p></p>
		<a href="Address_Insert"><input type="button"  value="添加"/></a>
</body>
</html>