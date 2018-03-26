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
<h1 style="margin-top: 50px">修改用户地址信息</h1>
	<form action="Address_Updata"   method="post" >
		<table border="box"  width="400px" height="400px" align="center">
			<tr>
				<td>Id</td>
				<td><input type="text" name="id"  value="${address.id }"  readonly="readonly"></td>
			</tr>
			<tr>
				<td>用户姓名</td>
				<td><input type="text" name="receiver_name"  value="${address.receiver_name }"  placeholder="请输入用户姓名"></td>
			</tr>
			<tr>
				<td>用户电话</td>
				<td><input type="text" name="receiver_phone" value="${address.receiver_phone }"  placeholder="请输入用户电话"></td>
			</tr>
			<tr>
				<td>用户手机</td>
				<td><input type="text" name="receiver_mobile"  value="${address.receiver_mobile }" placeholder="请输入用户手机"></td>
			</tr>
			<tr>
				<td>省份</td>
				<td><input type="text" name="receiver_province"  value="${address.receiver_province }" placeholder="请输入省份"></td>
			</tr>
			<tr>
				<td>城市</td>
				<td><input type="text" name="receiver_city"  value="${address.receiver_city } "placeholder="请输入城市"></td>
			</tr>
			<tr>
				<td>区/县</td>
				<td><input type="text" name="receiver_district"  value="${address.receiver_district }" placeholder="请输入区/县"></td>
			</tr>
			<tr>
				<td>详细地址</td>
				<td><input type="text" name="receiver_address"   value="${address.receiver_address }"placeholder="请输入详细地址	"></td>
			</tr>
			<tr>
				<td>邮编</td>
				<td><input type="text" name="receiver_zip"  value="${address.receiver_zip }" placeholder="请输入邮编	"></td>
			</tr>
		</table>
				<input type="submit"  value="修改">
				</form>
				<p></p>
				<a href="Address_Servlet?pageNo=1"><input type="button" value="取消" ></a>
	
</body>
</html>