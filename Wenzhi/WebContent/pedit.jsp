<%@page import="site.chiyu.bean.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
</head>
<style>
#butt{background: none transparent scroll repeat 0% 0%;border:1px soild lightskyblue; border-radius: 2%;}
body{
   		background:url(img/backgroud.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
}

.detail{

	width:300px;	
	
}
.tx{padding-left:55px;padding-top:20px;}

.round_icon{
  width: 150px;
  height: 150px;
  display: flex;
  border-radius: 50%;
  align-items: center;
 
  justify-content: center;
  overflow: hidden;
}


#text{
background: none transparent scroll repeat 0% 0%;
border-style:none;
border-bottom-style:solid;
border-bottom-width:thin;
border-bottom-color:red;}
.banquan{align:center;margin:200px 600px 0px 600px;}

</style>
<body>
	<%
		Member loginMember = (Member)session.getAttribute("loginMember");
	
	
	
	%>
	<div class="header">
	
	
	
	
	</div>
	<div class="body" align="center">
		<form action="PeditServlet" method="post" enctype="multipart/form-data">	
			
			<div class="tx" >
			<a id="txa">
			<img src="img/tx/<%=loginMember.getTx() %>" class="round_icon"  alt="">
			</a>	
			<br>
			<a style="padding-left:100px;">
			<input id="butt"type="file" value="选择头像"  name="file">
			</a>
			</div>	
			
			<br>
			<div class="detail" >
				<a style="padding-right:32px;" >修改昵称:</a>
				<input type="text" name="nickname" id="text">
				<br>
				<a style="padding-right:1px;" >修改个性签名:</a>
				<input type="text" name="sig" id="text">
				<br>
				<a style="padding-right:32px;">修改性别:</a>
				<input type="text" name="sex" id="text">
				<br>
				<a style="padding-right:1px;">请输入新密码:</a>
				<input type="text" name="pass" id="text">
				<br>
				
			</div>
			<br>
			<a style="padding-left:85px;">
			<input  id ="butt" type="submit" value="修改信息">
			</a>
		</form>
	
	
	</div>
	d<div class="banquan">
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