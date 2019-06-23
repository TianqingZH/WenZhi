package site.chiyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Member;
import site.chiyu.dao.impl.AnswerDaoImpl;

public class EditAnsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Answer answer = new Answer();
		AnswerDaoImpl answerDaoImpl = new AnswerDaoImpl();
		String wanswer = req.getParameter("wanswer");
		String topId = req.getParameter("topId");
		Member member = (Member) session.getAttribute("loginMember");
		PrintWriter writer = resp.getWriter();
		int len = answerDaoImpl.list().size();
		answer.setAnswerId("h"+(Math.random()*9+1)*10);
		answer.setTopId(topId);
		answer.setAnsCon(wanswer);
		answer.setComCount(0);
		answer.setCtime(new Timestamp(new Date().getTime()));
		answer.setMemId(member.getMemId());
		answer.setZan(0);
		int size = answerDaoImpl.add(answer);
		if (size>0) {
			
			writer.write("<script>alert('success!'</script>");
			
		}else {
			writer.write("<script>alert('failed!'</script>");
		
		}
		
		
		resp.setHeader("refresh", "3;url =FindDetailServlet?topId="+topId);
		}
	

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}

}
