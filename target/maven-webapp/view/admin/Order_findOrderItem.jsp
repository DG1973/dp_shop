<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

		<style>
			* {font-size: 12px;
			}
			 a{
				text-decoration: none;
			}
			a:hover{
				color: #f84a4b;
				text-decoration:none;
			}
			td{
				
				text-align: center;
			}
		</style>
		
</head>
<body>
<h1 style="font-size: 40px " align="center">订单详情信息管理</h1>
			<table border=1px  cellspacing="0" cellpadding="0" style="width:90%" align="center">
			<tr>
				<th>订单编号</th>	
				<th>用户账号</th>	
				<th>收货人姓名</th>	
				<th>商品名称</th>	
				<th>商品图片</th>	
				<th>商品单价</th>	
				<th>商品数量</th>
				<th>商品总价</th>
				<th>支付类型</th>
				<th>运费</th>
				<th>订单状态 </th>
				<th>支付时间</th>
				<th>发货时间</th>
				<th>交易完成时间</th>
				<th>交易关闭时间</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>区/县</th>
				
				
			</tr>
		<c:forEach items="${orderVO.userOrderItems}" var="order">		
			<tr>
				<td >${orderVO.order_no}</td>
				<td>${orderVO.username}</td>
				<td>${orderVO.receiver_name}</td>
			
				<td>
					<a href="Order_Servlet?operation=2&order_no=${order_no}" >${order.product_name}</a>
				</td>	
							
				<td>${order.product_image}</td>	
				<td>${order.current_unit_price}</td>	
				<td>${order.quantity}</td>	
				<td>${order.total_price}</td>			
				<td >${orderVO.payment_type}</td>
				<td >${orderVO.postage}</td>
				<td >${orderVO.status}</td>
				<td>${orderVO.payment_time}</td>
				<td>${orderVO.send_time}</td>
				<td>${orderVO.end_time}</td>
				<td>${orderVO.close_time}</td>
				<td>${orderVO.create_time}</td>
				<td>${orderVO.update_time}</td>
				<td>
					<a href="#">隐藏</a>
				</td>
			</tr>
			</c:forEach>	
			
		</table>
		   	<p></p>
    		<p></p>
		<div align="center">
			<c:forEach  var="pageNo" begin="1" end="${pageModel.totalPage}"  step="1">		     
		      <a href="Order_Servlet?operation=2&pageNo=${pageNo}&pageSize=2&order_no=${order_no}"  id="pageNo" style="font-size: 18px">${pageNo}</a>
		   		 &nbsp &nbsp
		      
		    </c:forEach>
    </div>
 
</body>
</html>