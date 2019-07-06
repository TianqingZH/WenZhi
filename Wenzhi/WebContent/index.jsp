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
<title>首页-问知</title>
</head>
<script type="text/javascript">
    
    function show(){
       // window.location.href = "../jsp/TestFile.jsp?id="+id+"&&sname="+sname+"&&cname="+cname;
    	document.getElementById("xtw").style.display = "block";
    }
    function del(){ 
    	if(!confirm("您确定要删除该提问吗？")){ 
    	window.event.returnValue = false; 
    	} 
    	} 
    function exit(){ 
    	if(!confirm("您确定要退出问知吗？")){ 
    	window.event.returnValue = false; 
    	} 
    	}
</script>
<style>
	#sub{background: none transparent scroll repeat 0% 0%;border:1px soild lightskyblue; border-radius: 2%;}
	#xtw{display:none;float:right;padding-right:100px;}
	#xtwtext{cursor:pointer;color:pink}
	#deTopic{width:249px;height:50px;backgroud:pink;background: none transparent scroll repeat 0% 0%;border:1px soild lightskyblue; border-radius: 2%;}
	#total{width:400px;margin:0 auto;height:100%}
	#body{float:left;width:400px;margin:0 auto;height:100%}
	#person{float:left;margin-left:200px;height:100%; }
	#delete{text-decoration: none;color:red;}
	#delete:hover{color:pink}
	.title{}
	.detail{color:#000000;text-decoration: none;padding-top:10px;font-size:25px;font-weight:bold;}      /* 未访问链接*/
	.detail:hover{color:pink}
	.ansNickName{text-decoration: none;color:#000000;} 
	.ansNickName:hover{color:pink}
	.floatText{z-index:99999999}
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
.banquan{align:center;margin:200px 600px 0px 600px;color:blue}


</style>
<body >
	<% 
		Member loginMember = (Member)session.getAttribute("loginMember");
		String nickName = loginMember.getNickname();
		String memId =  loginMember.getMemId();
		String tx = loginMember.getTx();
		String isAdmin = loginMember.getIsAdmin();
		Map<String,String> map= (Map<String,String>)session.getAttribute("map");
		Map<String,Member> mebMap = (Map<String,Member>)session.getAttribute("mebMap");
		
	
	%>
	<div class="header" align="center">
		<h2>首页-问知</h2>	
		<!--  
		<form action="">
		
			<input type="text" name="search">
			&nbsp;&nbsp;&nbsp;
			<input type="submit" value="搜索">
		
		</form>
		-->
		<hr>
	</div>
	<div id="total" align="center">
	<div class="body" id ="body" align="center">
	
		<% 	
		
			if(map !=null){
			for (Entry<String, String> entry : map.entrySet()) {		
		%>	
			
			<div class="Card">
			<a class= "detail" target="_Blank" href="FindDetailServlet?topId=<%=entry.getKey().split("\\|")[1]%>"><%=entry.getKey().split("\\|")[0] %></a>
			<%
				if("1".equals(isAdmin)){
			%>
			<div>
			<a id="delete" onclick="return del()" href="DeleteServlet?topId=<%=entry.getKey().split("\\|")[1]%>&flag=delTopic">删除</a>
			</div>
			<%
				}
			
			%>
			<div class="content">
			<%
			
			String AnsNickName="";
			Member member = mebMap.get(entry.getValue());
			if(member!=null){
				AnsNickName = member.getNickname(); 
				//out.print(AnsNickName+":");
				%>
			<a class="ansNickName" target="_Blank" href="FindPersonServlet?CurrentmemId=<%=member.getMemId()%>"  ><%=AnsNickName %>:</a>
			<% 
			}
			
			%>
				
			
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
	

	</div >
		<div class="person" id="person">
		<img src="img/tx/<%=tx %>" class="round_icon"  alt="">
		<h2><a target="_Blank" href="FindPersonServlet?CurrentmemId=<%=loginMember.getMemId()%>"><%=nickName %></a></h2>
		<h2><a id ="xtwtext"onclick="show()">写提问</a></h2>
		<h3><a id ="xtwtext" onclick="return exit()" href="ExitServlet">退出系统</a></h3>
	</div>
	
		
	<div >
	
	
	</div>
	<!--  <a href="person.jsp">个人页</a>
	<a href="detail.jsp">问题详情页</a>-->
	<br>
	<div id="xtw" >
		<form action="EditTopicServlet" method="post">
		提问：<input id="deTopic"type="text" onchange="show()" name="editTopic">
		<br>
		<p align="center"><input id="sub"type="submit" value="发布问题" ></p>
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