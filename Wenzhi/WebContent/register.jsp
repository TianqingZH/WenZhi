<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你好，欢迎来到问之</title>
</head>
<style>
.reg{align:center;margin:200px 600px 200px 600px}

#text{
background: none transparent scroll repeat 0% 0%;
border-style:none;
border-bottom-style:solid;
border-bottom-width:thin;
border-bottom-color:red;}
#sub{background: none transparent scroll repeat 0% 0%; }
body{
		
   		background:url(img/backgroud1.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
}

.banquan{align:center;margin:200px 600px 0px 600px;color:blue}


</style>
<body>
	<div class="reg">
		
		<h2>成为我们的一员       </h2>
		<form action="RegisterServlet" method="post">
			账号：<input type="text" name = "memId" id="text">
			<br><br>
			昵称：<input type="text" name="nickname" id="text">
			<br><br>
			密码：<input type="password" name="pass" id="text">
			<br><br>
			
			<input type="submit" value="注册" id="sub">		
		</form>
		
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