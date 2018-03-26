<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="view/css/login.css" />
<title>Insert title here</title>
</head>
<body  style="background-image: url('view/login_img/timg.jpg');">
		<form action="login.do"   method="post" >
				<table style="margin-top: 300px;margin-left: 600px ; width: 280px;background-color:#E8E8E8 ;">
				
					<tr>
						<td><img src="view/login_img/2018-01-07_143212.png"  class="c1"/></td>
						<td><input type="text"  name="zhanghao"  placeholder="请输入用户名"></td>
					</tr>
					
					<tr>
						<td><img src="view/login_img/2018-01-07_143231.png" class="c1"/></td>
						<td><input type="password" name="password"  placeholder="请输入用户名"></td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="登录" style="margin-right: 10px;width: 60px;height: 25px;"/> 
							<input type="button" value="注册" style="margin-left: 10px;width: 60px;height: 25px;"/>
						</td>
					</tr>
				
				</table>
			</form>

</body>
</html>