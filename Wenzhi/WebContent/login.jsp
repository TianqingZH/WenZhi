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
	
		<form  action="LoginServlet" method="post" >
			账号：<input type="text" name="memId">
			<br>
			密码：<input type="password" name="pass">
			<br>
			<input type="submit" value="登录">
		</form>
	
	</div>
</body>
</html>