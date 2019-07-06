<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你好，欢迎来到问知</title>
</head>
<style>

.login{align:center;margin:200px 600px 200px 600px}

.banquan{align:center;margin:200px 600px 0px 600px;color:blue}
#text{
background: none transparent scroll repeat 0% 0%;
border-style:none;
border-bottom-style:solid;
border-bottom-width:thin;
border-bottom-color:red;}
#sub{background: none transparent scroll repeat 0% 0%;border:1px soild lightskyblue; border-radius: 2%;}
body{
   		background:url(img/background.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
}

</style>
<body >

	<div class="login">
		<h2 >欢迎来到问知</h2>
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
	<div class="banquan">
		<p id="btext">Copyright©2018-2019第二学期  
			<br>
			计算机1601班
			<br>
			1630090013 贺嘉琦  1630090002 李辉
		  	<br>
		  	版权所有
		  </p>
	</div >

</body>
</html>