<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<frameset rows="200px,800px,200px"frameborder="1" >
		<frame src="home/top.jsp" scrolling="no"/>
		<frameset cols="250px,*">
			<frame src="home/menu.jsp"scrolling="no" />
			<frame src="home/li_01.html" name="zt"/>
		</frameset>
		<frame src="home/bottom.jsp"scrolling="no" />
		
	</frameset>
</html>