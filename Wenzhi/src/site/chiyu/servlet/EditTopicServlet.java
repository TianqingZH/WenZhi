package site.chiyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.chiyu.bean.Dyna;
import site.chiyu.bean.Member;
import site.chiyu.bean.Topic;
import site.chiyu.dao.impl.DynaDaoImpl;
import site.chiyu.dao.impl.TopicDaoImpl;

public class EditTopicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		TopicDaoImpl topicDaoImpl = new TopicDaoImpl();
		Dyna dyna = new Dyna();
		DynaDaoImpl dynaDaoImpl = new DynaDaoImpl();
		PrintWriter writer = resp.getWriter();
		Member member = (Member) session.getAttribute("loginMember");
		String editTopic = req.getParameter("editTopic");
		System.out.println("editTopic:"+editTopic);
		if(editTopic!=null){
		Topic topic  = new Topic();
		//int len = topicDaoImpl.list().size();
		topic.setTopId("w"+(Math.random()*9+1)*10);
		topic.setMemId(member.getMemId());
		topic.setTopCon(editTopic);
		topic.setCtime(new Timestamp(new Date().getTime()));
		topic.setMtime(new Timestamp(new Date().getTime()));
		dyna.setDynaId("d"+(Math.random()*9+1)*10);
		dyna.setCtime(new Timestamp(new Date().getTime()));
		dyna.setMemId(member.getMemId());
		dyna.setotherId(topic.getTopId());
		dyna.setFlag("4");
		
		int size = topicDaoImpl.add(topic);
		dynaDaoImpl.add(dyna);
		if (size>0) {
			
			writer.write("<script>alert('success!')</script>");
			
		}else {
			writer.write("<script>alert('failed!')</script>");
		
		}
		}
		
		resp.setHeader("refresh", "0;url =FindIndexServlet");
		
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}
	
}
