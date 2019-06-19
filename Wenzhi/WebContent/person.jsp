<%@page import="site.chiyu.bean.Topic"%>
<%@page import="site.chiyu.dao.impl.TopicDaoImpl"%>
<%@page import="site.chiyu.dao.impl.MemberDaoImpl"%>
<%@page import="site.chiyu.bean.Answer"%>
<%@page import="java.util.List"%>
<%@page import="site.chiyu.bean.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

.round_icon_Person{
  width: 150px;
  height: 150px;
  display: flex;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}
body{
   		background:url(img/backgroud.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
}


</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>

<body>

	<%
		Member currentMember = (Member)session.getAttribute("CurrentMember");
		List<Object> dynaObjects = (List<Object>)session.getAttribute("Dyna");
		String loginmemId = (String) session.getAttribute("memId");
	
	
	
	%>
	<div class="person" align="center">
		<br>
		<div class="tx">
			<img  src="img/tx/<%=currentMember.getTx() %>" class="round_icon_Person"  alt="">
		</div>
		<br>
		<div class="currentMemberInfo" align="center">
			<span><%=currentMember.getNickname() %></span>
		</div>
		<a style="font-size:13px"><%=currentMember.getSig() %></a>
		<br>
		<%if (currentMember.getMemId().equals(loginmemId)){%>
		<a href="pedit.jsp">编辑个人资料</a>
		<%} %>
	</div>
	
	<div class="body" align="center">
		
		<%
			if(dynaObjects.size()>0){
				for(int i = 0;i<dynaObjects.size();i++){
					String clazzString = (String)dynaObjects.get(dynaObjects.size()-1-i);
					//赞同或评论回答
					if(clazzString.equals("Answer|0")||clazzString.equals("Answer|1")){
						String flag = clazzString.split("\\|")[1];
						Answer answer = (Answer)dynaObjects.get(dynaObjects.size()-i);
						Member agreeMember = new MemberDaoImpl().getMember(answer.getMemId());
						Topic nowTopic = new TopicDaoImpl().getTopic(answer.getTopId());
						%>
						
						<div>
						<% if(flag.equals("0")){ %>
						<div class="agreeAnswer">
							<a>赞同了回答</a>
							<br>
						</div>
						<%}else{ %>
							<div class="agreeAnswer">
							<a>评论了回答</a>
							<br>
						</div>
						
						<%} %>
						<div class="nowTopic">
						
							<h2><a href="FindDetailServlet?topId=<%=nowTopic.getTopId()%>"><%=nowTopic.getTopCon() %></a></h2>
						</div>	
						<div class="person1"> 
							<div class="tx">
								<img  src="img/tx/<%=agreeMember.getTx() %>" class="round_icon_Agree"  alt="">
							</div>
							<div class="memberInfo">
							<b><%=agreeMember.getNickname() %></b>
							<br>
							<a style="font-size:13px"><%=agreeMember.getSig() %></a>
							</div>
						</div>
						<br><br>
						<div class="detailanswer">
							<a class="zantong" style="font-size:13px"><%=answer.getZan() %>人赞同了回答</a>
							<br>
							<span class="huida" align="left"><%=answer.getAnsCon() %></span>
						
				
							<a class="time" align="left" >编辑于：<%=answer.getCtime() %></a>
						</div>
						<br>
						<br>
						<hr>
						
						
						<%
					}
					//回答主题
					else{

						Topic nowTopic = (Topic)dynaObjects.get(dynaObjects.size()-i);
						%>
						<div class="answerTopic">
							<a>回答了主题</a>
							<h2><a href="FindDetailServlet?topId=<%=nowTopic.getTopId()%>"><%=nowTopic.getTopCon() %></a></h2>
						
						</div>
						
						
						<%
						
					}
						
					
					
					
					
				}
			}
		
		%>
		
		
	</div>
	
	</div>
</body>
</html>