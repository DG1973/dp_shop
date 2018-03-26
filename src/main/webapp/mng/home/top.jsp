<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<style type="text/css">
			*{
				margin: 0px;
				padding: 0px;
				}
			#top{
				position: relative;
				margin-left: 400px;
				margin-right: 250px;
				
				display: flex;
			}
			#top>span{
				flex-grow: 1;
				font-size: 45px;
				text-align: center;
				margin-top: 30px;
				
			}
		</style>
	</head>
	<body style="">
		<div style="height: 125px;margin: 0 auto;">
			<div style="float: left;">
				<img src="../img/题目.JPG" height="125px"width="400px" />
			</div>
			
			<div id="top">
				<span>道</span>
				<span>聚</span>
				<span>城</span>
				<span>后</span>
				<span>台</span>
				<span>管</span>
				<span>理</span>	
				<p>欢迎${user.username}登录    <a href="http://localhost:8080/dp_shop/User_quit">退出登录</a></p>	
			</div>
			
			<div style="float: right;margin-top: -90px;">
				<img src="../img/二维码.JPG" height="125px"width="250px"/>
			</div>
		</div>
	</body>
</html>