package site.chiyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Comm;
import site.chiyu.bean.Dyna;
import site.chiyu.dao.impl.AnswerDaoImpl;
import site.chiyu.dao.impl.CommDaoImpl;
import site.chiyu.dao.impl.DynaDaoImpl;

public class WriteCommAndZanServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String comm = req.getParameter("writeyourComm");
		Comm comm2 = new Comm();
		AnswerDaoImpl answerDaoImpl = new AnswerDaoImpl();
		CommDaoImpl commDaoImpl = new CommDaoImpl();
		DynaDaoImpl dynaDaoImpl = new DynaDaoImpl();
		Dyna dyna = new Dyna();
		String answerId = req.getParameter("answerId");
		System.out.println("anserId:"+answerId);
		String beizanmemId = req.getParameter("beizanmemId");
		String loginMemId  =  (String)session.getAttribute("memId");
		String flag = req.getParameter("flag");
		System.out.println("flag!!"+flag);
		Answer answer  = answerDaoImpl.getAnswer(answerId);
		String topId = answer.getTopId();
		System.out.println("MemId:"+loginMemId);
		Dyna judgeDyna = dynaDaoImpl.getDynaBymemIdandotherIdandflag(loginMemId, answerId, flag);
		PrintWriter writer = resp.getWriter();
		//System.out.println("haveDynaId:"+haveDynaId);
		//0:赞同，并且没有赞同过该回答
		if("0".equals(flag)&&(judgeDyna ==null)){
			int zan = answer.getZan();
			System.out.println("zan:"+zan);
			zan++;
			System.out.println("zan:"+zan);
			answer.setZan(zan);
			System.out.println("answerCon:"+answer.getAnsCon());
			answerDaoImpl.updateAnswer(answer);
			dyna.setDynaId("d"+(Math.random()*9+1)*10);
			dyna.setCtime(new Timestamp(new Date().getTime()));
			dyna.setFlag("0");
			dyna.setMemId(loginMemId);
			dyna.setotherId(answerId);
			dynaDaoImpl.add(dyna);
			writer.write("<script>alert('您已赞同！')</script>");
		}//1:评论 ，可以多次评论
		else if("1".equals(flag)){
			int comCount = answer.getComCount();
			comCount++;
			answer.setComCount(comCount);
			answerDaoImpl.updateAnswer(answer);
			comm2.setCommId("c"+(Math.random()*9+1)*10);
			comm2.setCommCon(comm);
			comm2.setCtime(new Timestamp(new Date().getTime()));
			comm2.setAnswerId(answerId);
			comm2.setMemId(loginMemId);
			commDaoImpl.add(comm2);
			writer.write("<script>alert('发表评论成功！')</script>");
		}else {
			writer.write("<script>alert('您已赞同过，请勿重复操作！')</script>");
		}
		resp.setHeader("refresh", "0;url=FindDetailServlet?topId="+topId);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}

}
