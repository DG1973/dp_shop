<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<link />
		<title></title>
		<style type="text/css">
		*{	
			padding: 0;
			margin: 0;
		}
		#header{
			background-color: dodgerblue;
			color: white;
			height: 60px;
			line-height:60px  ;
			padding-left: 10px;
		}
		ul{
			list-style: none;
			width: 10%;
			background-color:  #f1f1f1;
			position: fixed;
			box-shadow: 0px 4px 8px 0px darkgrey;
			height: 100%;   
		}	
		#d1 img{		
		 	padding: 10px 5px;
			}
		#d1{
		  	border-bottom: 1px solid  gainsboro ;
		}
		li a{
	  		text-decoration: none;
	  		display: block;
      		color: #000;
     		 padding: 10px 20px;
     		 border-bottom: 1px solid  gainsboro ;
		}
		.active{
			background-color: greenyellow;
			color: white;
		}
	
		a:hover:not(.active){
			 color: dodgerblue;
		}
		#d2>ul{
			display: none;
			width: 10%;
			background-color:  #f1f1f1;
		}
		#d2:hover ul{
			display: block;
		}
		.c1{
			background-color:#F8F8F8; 
		}.c2{
			display: inline-block;
			padding: auto 0px ;
			
		}
		</style>
	</head>
	<body>
		<div id="header" >
			<h2>电商后台管理系统    欢迎${user.username}登录 ，<a href="http://localhost:8080/dp_shop/User_quit">退出登录</a></h2>
			
		</div>
		
	<ul >
  		<li id="d1"> <img src="img/2018-02-20_155247.png"><img src="img/2018-02-20_155306.png" /><img src="img/2018-02-20_155338.png" /><img src="img/2018-02-20_155416.png" />  </li>
  		<li>
  				<details  style="outline: none; ">
  		<summary ><a href="#" target="houtai" class="c2"><img src="img/商品管理.png" >&nbsp;商品管理</a></summary >
  			<p class="c1"><a href="/dp_shop/Product_Servlet?pageNo=1" target="houtai">商品列表</a></p>
			<p class="c1"><a href="/dp_shop/Categoty_Servlet?pageNo=1" target="houtai">商品分类</a></p>
  			</details>
  		</li>
 		<li >	
 			<details  style="outline: none; ">
 	<summary ><a href="#" target="houtai"class="c2"><img src="img/订单管理.png" >&nbsp;订单管理</a></summary>
 				<p class="c1"><a href="订单管理（未付款）.html" target="houtai">待付款订单</a></p>
					<p class="c1"><a href="订单管理（已付款）.html" target="houtai">已付款订单</a></p>
					<p class="c1"><a href="订单管理（已发货）.html" target="houtai">已发货订单</a></p>
					<p class="c1"><a href="订单管理（已完成）.html" target="houtai">已完成订单</a></p>
  		
 			</details>	
 		</li>
  		<li><a href="会员管理.html" target="houtai"><img src="img/客户会员管理.png" >&nbsp;会员管理</a></li>
  		 <li><a href="#contact" target="houtai"><img src="img/系统设置.png" >&nbsp;系统设置</a></li>
  		<li><a href="#about" target="houtai"><img src="img/消息 (1).png" >&nbsp;消息</a></li>
	</ul>
	
	
	<iframe  frameborder="0" name="houtai" src="" style="width: 80%; height: 500px; position: relative; left: 10%; " ></iframe>
</body>
</html>