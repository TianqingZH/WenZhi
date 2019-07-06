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
	#return{text-decoration: none;}
.content{width:400px;margin:0 auto;height:100%}
#body{float:left;width:400px;height:100%}
.round_icon_Person{
  width: 150px;
  height: 150px;
  display: flex;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}
.round_icon_Agree{
  width: 35px;
  height: 35px;
  display: flex;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  float:left;
}
.agreeAnswer{float:left;width:90px;left:0;height:100%;color:#000000;margin-top:13px;}
.zantong{float:left;width:90px;left:0;height:100%;color:#000000}
.newTopic{float:left;margin-top:10px;margin-left:0;height:100%;width:400px;}
.answerTopic{float:left;width:90px;left:0;height:100%;color:#000000;margin-top:13px;}
.topicAnswer{}
.person1{float:left;witdth:200px;margin-right:200px;height:100%}
.memberInfo{float:left;width:110px;margin-left:0;height:100%}
.person1tx{float:left;width:35px;height:100%}
.huida{float:left;width:400px;margin-left:0;height:100%}
.time{float:left;width:400px;margin-left:0;height:100%;margin-top:10px;font-size:11px}
body{
   		background:url(img/backgroud.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:(3,22,52);
}

.banquan{align:center;margin:0px 600px 0px 600px;color:blue}

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
		<a id="return"href="FindIndexServlet"> 返回主页 </a>&nbsp;
		<%if (currentMember.getMemId().equals(loginmemId)){%>
		<a href="pedit.jsp">编辑个人资料</a>
		<%} %>
	</div>
	<hr>
	<div class="content" align="center">
		
		<%
			if(dynaObjects.size()>0){
				int i ;
				for(i = 0;i<dynaObjects.size();i++){
					
					String clazzString = (String)dynaObjects.get(dynaObjects.size()-2-i);
					
					
					//赞同或评论回答
					if("Answer|0".equals(clazzString)||"Answer|1".equals(clazzString)){
						String flag = clazzString.split("\\|")[1];
						
						Answer answer = (Answer)dynaObjects.get(dynaObjects.size()-i-1);
						Member agreeMember = new MemberDaoImpl().getMember(answer.getMemId());
						Topic nowTopic = new TopicDaoImpl().getTopic(answer.getTopId());
						%>
						
						<div>
						<% if("0".equals(flag)){ %>
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
					
						<br>
						<div class="nowTopic" align="left">
						
							<h3><a href="FindDetailServlet?topId=<%=nowTopic.getTopId()%>"><%=nowTopic.getTopCon() %></a></h3>
						</div>	
						
						<div class="person1"> 
							<div class="person1tx">
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
					else if("topic".equals(clazzString)){

						Topic nowTopic = (Topic)dynaObjects.get(dynaObjects.size()-i-1);
						%>
						<div class="topicAnswer" >
							<div class="answerTopic">
							<a>回答了主题</a>
							<br>
							</div>
							<br>
							<div class="nowTopic" align="left">
							<h3><a href="FindDetailServlet?topId=<%=nowTopic.getTopId()%>"><%=nowTopic.getTopCon() %></a></h3>
							</div>
						</div>
						
						<hr>
						<%
						
					}
					//发布了主题，提问
					else{
						Topic nowTopic = (Topic)dynaObjects.get(dynaObjects.size()-i-1);
						%>
						
						<div class="topicAnswer" >
							<div class="answerTopic">
							<a>发起了提问</a>
							<br>
							</div>
							<br>
							<div class="nowTopic" align="left">
							<h3><a href="FindDetailServlet?topId=<%=nowTopic.getTopId()%>"><%=nowTopic.getTopCon() %></a></h3>
							</div>
						</div>
						
						<hr>
						
					
					
				<%	
					}	
				i++;	
				}
			}else{
				
				%>
				<h3>暂时没有动态！</h3>
				<%
				
			}
		
		%>
		
		
	</div>
	
	
		<p id="btext" align="center">Copyright©2018-2019第二学期  
			<br>
			计算机1601班
			<br>
			1630090013 贺嘉琦  1630090002 李辉
		  	<br>
		  	版权所有
		  </p>

	
</body>

</html>