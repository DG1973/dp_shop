<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<style>
			tr:nth-child(odd)
			{	background:  -webkit-linear-gradient(top, #F8F8F8 ,	#E8E8E8 );
				background:  -moz-linear-gradient(top, #F8F8F8 ,	#E8E8E8 );
				background:  -o-linear-gradient(top, #F8F8F8 ,	#E8E8E8 );
				background:  -ms-linear-gradient(top, #F8F8F8 ,	#E8E8E8 );
			}
  
	</style>
			
		</style>
		<script type="text/javascript">
			function click(){
				alert("aaa");
			}
		
			//document.write("111"）;
			/*href="http://localhost:8080/dp_shop/view/Order_Servlet?operation=2&pageNo=1&pageSize=2&order_no="+num; */
		
	</script>
<title>Insert title here</title>
</head>
<body>
<h1 style="font-size: 40px " align="center">订单信息管理</h1>


<input type="text" name="order_no" id="order_no" >

<a onclick="click()"><input type="button"  value="查找"></a>

<table border=1px  cellspacing="0" cellpadding="0" style="width:1200px" align="center">
			<tr>

				<th>订单编号</th>	
				<th>用户账号</th>	
				<th>收货人姓名</th>	
				<!-- <th>收货人固定电话</th>	 -->
				<th>联系方式</th>	
				<th>省份</th>
				<th>城市</th>
				<th>区/县</th>
				<th>详细地址</th>
				<th>邮编</th>
				<th>付款金额</th>
				<th>支付类型</th>
				<th >运费</th>
				<th >订单状态 </th>
				<th>支付时间</th>
				<th>发货时间</th>
				<th>交易完成时间</th>
				<th>交易关闭时间</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>操作</th>
				
				
			</tr>
			<c:forEach items="${pageModel.data}" var="order">
			<tr>
				<td>
					<a href="Order_Servlet?operation=1&order_no=${order.order_no}">
						${order.order_no}
					</a>
				</td>
				<td>${order.username}</td>				
				<td>${order.receiver_name}</td>
				<%-- <td>${order.receiver_phone}</td> --%>
				<td>${order.receiver_mobile}</td>
				<td>${order.receiver_province}</td>
				<td>${order.receiver_city}</td>
				<td>${order.receiver_district}</td>
				<td>${order.receiver_address}</td>
				<td>${order.receiver_zip}</td>
				<td>${order.payment}</td>
				<td>${order.payment_type}</td>
				<td>${order.postage}</td>
				<td>${order.status}</td>
				<td>${order.payment_time}</td>
				<td>${order.send_time}</td>
				<td>${order.end_time}</td>
				<td>${order.close_time}</td>
				<td>${order.create_time}</td>
				<td>${order.update_time}</td>
				

				<td>
					<p>
						<a href="#">
							<input type="button" value="修改">
						</a>
					</p>
					
					
					<p>
						<a href="#">
							<input type="button" value="删除">
						</a>
					</p>
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