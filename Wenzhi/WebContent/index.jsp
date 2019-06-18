<%@page import="site.chiyu.bean.Member"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页-问之</title>
</head>
<style>
	#total{width:400px;margin:0 auto;height:100%}
	#body{float:left;width:400px;margin:0 auto;height:100%}
	#person{float:left;margin-left:200px;height:100%}
	.detail{color:#000000;text-decoration: none;}      /* 未访问链接*/
	.detail:hover{color:pink}
	
	
	body{
   		background:url(img/backgroud.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
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
<body >
	<% 
		Member loginMember = (Member)session.getAttribute("loginMember");
		String nickName = loginMember.getNickname();
		String memId =  loginMember.getMemId();
		String tx = loginMember.getTx();
		
		Map<String,String> map= (Map<String,String>)session.getAttribute("map");
		Map<String,Member> mebMap = (Map<String,Member>)session.getAttribute("mebMap");
		//Map<String,String> map= (Map<String,String>)request.getAttribute("map");
		//out.print("map:"+map);
	
	%>
	<div class="header" align="center">
		<h2>首页</h2>	
		
		<form action="">
		
			<input type="text" name="search">
			&nbsp;&nbsp;&nbsp;
			<input type="submit" value="提问">
		
		</form>
		<hr>
	</div>
	<div id="total" align="center">
	<div class="body" id ="body" align="center">
	
		<% 	
		
			if(map !=null){
			for (Entry<String, String> entry : map.entrySet()) {		
		%>	
			
			<div class="Card">
			<h2 class="title"><a class= "detail" href="detail.jsp"><%=entry.getKey() %></a></h2>
			
			<div class="content">
			<a><%
			
			String AnsNickName="";
			Member member = mebMap.get(entry.getValue());
			if(member!=null){
				AnsNickName = member.getNickname(); 
				out.print(AnsNickName+":");
			}
			
				%></a>
			<a class="ans"><%=entry.getValue() %></a></div>
		
			</div>
			<hr>
		<%
			}
		}else{
			
			PrintWriter writer = response.getWriter();
			writer.write("出现了一点小问题!");
			
		}
		%>
		
	
	
	</div>
	

	</div>
		<div class="person" id="person">
		<img src="img/tx/<%=tx %>" class="round_icon"  alt="">
		<h2><a href="person.jsp"><%=nickName %></a></h2>
		<h2>写提问</h2>
	
	</div>
	<!--  <a href="person.jsp">个人页</a>
	<a href="detail.jsp">问题详情页</a>-->
	
</body>
</html>