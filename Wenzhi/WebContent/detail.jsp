<%@page import="java.util.Map"%>
<%@page import="site.chiyu.bean.*"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
    
    function show(){
       // window.location.href = "../jsp/TestFile.jsp?id="+id+"&&sname="+sname+"&&cname="+cname;
    	document.getElementById("write").style.display = "block";
    }
    function del(){ 
    	if(!confirm("尊敬的管理员，您确定要删除该回答吗？")){ 
    	window.event.returnValue = false; 
    } 
    }
    function delc(){ 
    	if(!confirm("尊敬的管理员，您确定要删除该评论吗？")){ 
    	window.event.returnValue = false; 
    } 	
    } 
</script>
<style>
	#dAns{text-decoration: none;color:red;}
	#delComm{text-decoration: none;color:blue;font-size:13px;margin-left:100px;}
	#writeSpan{font-size:13px}
	#writeyourComm{width:300px;background: none transparent scroll repeat 0% 0%;border:1px soild lightskyblue; border-radius: 2%;}
	#zanyx{text-decoration: none;color:green}
	#wanswer{width:200px;}
	#write{display:none}
	#xpl{float:left;}
	.content{width:400px;margin:0 auto;height:100%}
	#body{float:left;width:400px;height:100%}
	.person{float:left;witdth:200px;margin-right:200px;height:100%}
	.tx{float:left;width:35px;height:100%}
	.memberInfo{float:left;width:110px;margin-left:0;height:100%}
	.zantong{float:left;width:90px;left:0;height:100%;color:#CCCCCC}
	.huida{float:left;width:400px;margin-left:0;height:100%}
	.time{float:left;width:400px;margin-left:0;height:100%;margin-top:10px;font-size:11px}
	.totalAgree{float:left;width:95px;margin-left:0;height:100%;font-size:13px;cursor:pointer;color:green}
	
	.detail{color:#000000;text-decoration: none;}      /* 未访问链接*/
	.detail:hover{color:pink}
	.comPerson{float:left;witdth:200px;margin-right:200px;height:100%}
	.comPersonTx{float:left;width:25px;height:100%}
	.comPersonInfo{float:left;width:110px;margin-left:0;height:100%}
	.comDetail{float:left;witdth:400px;margin-left:0px;height:100%}
	.comDetailCon{float:left;width:400px;margin-left:0px;height:100%}
	body{
   		
   		background:url(img/backgroud.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
}
.round_icon_Ans{
  width: 35px;
  height: 35px;
  display: flex;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}
.round_icon_Comm{
  width: 25px;
  height: 25px;
  display: flex;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}
.banquan{align:center;margin:200px 600px 0px 600px;color:blue}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问知</title>

</head>
<body>
	<%
		Topic topic = (Topic)session.getAttribute("topic");
		Member loginMember = (Member)session.getAttribute("loginMember"); 
		Map<Member,Answer > mapMemAndAns = (Map<Member,Answer>)session.getAttribute("mapMemAndAns");
		Map<Member,Comm > mapMemAndComm = (Map<Member,Comm >)session.getAttribute("mapMemAndComm");
	
	
	
	%>
	<div class="header" align="center">
		<div class="topic"><h2><%=topic.getTopCon() %></h2></div>
		<button  onclick="show()"> 写回答</button>
		<div id="write">
			
			<form action="EditAnsServlet?topId=<%=topic.getTopId() %>" method="post">
			
				回答：<input id="wanswer"type="text"  name="wanswer" >
				<input type="submit" value="提交回答">
			</form>
		</div>
	</div>
	<hr>
	<div class="content" align="center">
	<%	if(mapMemAndAns !=null){
		for (Entry<Member, Answer> entry : mapMemAndAns.entrySet()) { 
			Member member = entry.getKey();
			Answer answer = entry.getValue();
	%>
		<div>
		<div class="person"> 
			<div class="tx">
				<img  src="img/tx/<%=member.getTx() %>" class="round_icon_Ans"  alt="">
			</div>
			<div class="memberInfo">
			<b><a href="FindPersonServlet?CurrentmemId=<%=member.getMemId()%>"><%=member.getNickname() %></a></b>
			<br>
			<a style="font-size:13px"><%=member.getSig() %></a>
			</div>
		</div>
		<%
			if("1".equals(loginMember.getIsAdmin())){
		%>
		<a id="dAns"  onclick="return del()" href="DeleteServlet?answerId=<%=answer.getAnswerId()%>&flag=delAns&topId=<%=topic.getTopId()%>">删除</a>
		<% 
			}
		%>
		
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
		</div>
		
		<div>
			<span class="totalAgree">
			<!-- 当前所赞同回答的id，当前所赞同回答的回答者用户id -->
			<span>
			<a id= "zanyx" href="WriteCommAndZanServlet?answerId=<%=answer.getAnswerId()%>&beizanmemId=<%=member.getMemId()%>&flag=0">
			<%
			out.print(answer.getZan()+"赞同&nbsp;");
			%>
			</a>
			</span>
			
			<span id="pinglun" onclick="writeComm()">
			<%
			out.print(answer.getComCount()+"条评论");
			%>
			</span>
			
			
			</span>
			
			<br>
			<div id="xpl">
			<form action = "WriteCommAndZanServlet?answerId=<%=answer.getAnswerId()%>&beizanmemId=<%=member.getMemId()%>&flag=1" method="post">
			<span id="writeSpan">说点什么吧:</span><input id="writeyourComm"type="text" name="writeyourComm">
			<br>
				<input type="submit" value="提交">
			</form>
			</div>
			<br>
		<% 
			//评论
			if(mapMemAndComm != null){
			for (Entry<Member, Comm> entry1 : mapMemAndComm.entrySet()) { 
						Member commMember = entry1.getKey();
						Comm comm = entry1.getValue();
						if(comm.getAnswerId().equals(answer.getAnswerId())){
						%>

						<div class="comPerson">
							<div class="comPersonTx">
							<img src="img/tx/<%=commMember.getTx() %>" class="round_icon_Comm"  alt="">
							</div>
							<div class="comPersonInfo" align="left">
							<a href="FindPersonServlet?CurrentmemId=<%=commMember.getMemId()%>"><%=commMember.getNickname() %></a>
							
							
							
							</div>
							<a id="delComm" onclick="return delc()" href="DeleteServlet?commId=<%=comm.getCommId()%>&flag=delCom&answerId=<%=answer.getAnswerId()%>&topId=<%=topic.getTopId()%>">删除评论</a>
						
						</div>
						<div class="comDetail" >
							<a class ="comDetailCon" align="left" style="font-size:13px"><%=comm.getCommCon() %></a>
						</div>
						
						<%
						}
				}
			}			
						
						%>
						<br>
						
		
		</div>
		<br>
		<hr>
		<br>
		
		<%
		
			}
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