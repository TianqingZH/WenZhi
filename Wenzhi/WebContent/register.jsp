<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你好，欢迎来到问之</title>
</head>
<body>
	<div align="center">
	
		<h1>欢迎注册！</h1><br>
		<form action="RegisterServlet" method="post">
			账号：<input type="text" name = "memId">
			<br>
			昵称:<input type="text" name="nickname">
			<br>
			密码：<input type="password" name="pass">
			<br>
			<input type="submit" value="注册">		
		</form>
	</div>
	
</body>
</html>