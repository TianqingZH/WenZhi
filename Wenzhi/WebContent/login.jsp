<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你好，欢迎来到问之</title>
</head>
<style>

.login{align:center;margin:200px 600px 200px 600px}

#text{
background: none transparent scroll repeat 0% 0%;
border-style:none;
border-bottom-style:solid;
border-bottom-width:thin;
border-bottom-color:red;}
#sub{background: none transparent scroll repeat 0% 0%;border:1px soild lightskyblue; border-radius: 2%;}
body{
		
   		background:url(img/backgroud1.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
}

</style>
<body >

	<div class="login">
		<h2 >欢迎来到问之</h2>
		<form  action="LoginServlet" method="post" id="loginForm">
			账号：<input type="text" name="memId" id="text">
			<br><br>
			密码：<input type="password" name="pass" id="text">
			<br><br>
			<input type="submit" value="登录" id="sub" >&nbsp;&nbsp;
			
		</form>
	
		<br>
		<a href="register.jsp">没有账号？立即注册</a>
	
	</div>
	
</body>
</html>