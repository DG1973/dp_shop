<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
		<style type="text/css">
			*{
				margin: 0px;
				padding: 0px;
			}
			ul{
				list-style: none;
			}
			li:first-child{
				border-top: 2px solid seashell;
			}
			ul li:last-child{
				border-bottom: 0px solid seashell;
			}
			li{
				height: 40px;
				font-size: 30px;
				width: 250px;
				text-align: center;
				color: white;
				padding-top: 10px;
				padding-bottom: 10px;
				border-top: 1px solid seashell;
				border-bottom: 1px solid seashell;
			}
			a{
				text-decoration: none;
			}
			a:hover li{
				background: white;
				color: black;
			}
		</style>
</head>
	<body style="background: #f84a4b;">	
		<ul>
			<a href="li_01.html" target="zt"><li>首页</li></a>
			<a href="../zt/li_02.html" target="zt"><li>基本设置</li></a>
			<a href=" http://localhost:8080/dp_shop/mng/Product_Servlet?pageNo=1" target="zt"><li>商品管理</li></a>
			<a href="http://localhost:8080/dp_shop/mng/Categoty_Servlet?pageNo=1"" target="zt"><li>商品分类</li></a>
			<a href="../zt/li_05.html" target="zt"><li>库存管理</li></a>
			<a href="http://localhost:8080/dp_shop/view/Order_Servlet?operation=2&pageNo=1&pageSize=2&order_no=" target="zt"><li>订单管理</li></a>
			<a href="http://localhost:8080/dp_shop/mng/User_Servlet?pageNo=1" target="zt"><li>会员管理</li></a>
		</ul>
	</body>
</html>