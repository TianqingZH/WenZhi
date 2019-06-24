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

body{
   		background:url(img/backgroud.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
}

.detail{

	width:500px;	
	
}
.round_icon{
  width: 150px;
  height: 150px;
  display: flex;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}



</style>
<body>
	<%
		Member loginMember = (Member)session.getAttribute("loginMember");
	
	
	
	%>
	<div class="header">
	
	
	
	
	</div>
	<div class="body" align="center">
		<form action="PeditServlet" method="post" enctype="multipart/form-data">	
			
			<div class="tx" align="center">
			<img src="img/tx/<%=loginMember.getTx() %>" class="round_icon"  alt="">
				
			<br>
			<input type="file" value="选择头像"  name="file">
			</div>	
			
			<br>
			<div class="detail" >
			<a><%=loginMember.getNickname() %>:<input type="text" name="nickname"></a><br>
				<br>
				<a><%=loginMember.getSex() %>:<input type="text" name="sex"></a>
				<br>
				<a><%=loginMember.getSig() %>:<input type="text" name="sig"></a>
				<br>
			</div>
			<input type="submit" value="保存">
			
		</form>
	
	
	</div>
</body>
</html>