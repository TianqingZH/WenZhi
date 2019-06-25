package site.chiyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.ID;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Comm;
import site.chiyu.bean.Dyna;
import site.chiyu.bean.Topic;
import site.chiyu.dao.impl.AnswerDaoImpl;
import site.chiyu.dao.impl.CommDaoImpl;
import site.chiyu.dao.impl.DynaDaoImpl;
import site.chiyu.dao.impl.TopicDaoImpl;

public class DeleteServlet extends HttpServlet {

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int res = 0;
		int res1 = 0;
		
		
		String flag = req.getParameter("flag");
		String topId = req.getParameter("topId");
		String answerId = req.getParameter("answerId");
		PrintWriter writer = resp.getWriter();
		AnswerDaoImpl answerDaoImpl = new AnswerDaoImpl();
		DynaDaoImpl dynaDaoImpl = new DynaDaoImpl();
		if ("delTopic".equals(flag)) {
			TopicDaoImpl topicDaoImpl = new TopicDaoImpl();
			
			res = topicDaoImpl.delete(topId);
			res1 = dynaDaoImpl.deleteByOtherId(topId);
			//再删除动态表中数据
			if (res!=0&&res1!=0) {
				writer.write("<script>alert('删除主题成功！')</script>");
			}
			resp.setHeader("refresh", "0;url = FindIndexServlet");
		}
		
		if ("delAns".equals(flag)) {
			
			
			res = answerDaoImpl.delete(answerId);
			res1 = dynaDaoImpl.deleteByOtherId(answerId);
			if (res!=0&&res1!=0) {
				writer.write("<script>alert('删除回答成功！')</script>");
			}
			resp.setHeader("refresh", "0;url = FindDetailServlet?topId="+topId);
		}
		if ("delCom".equals(flag)) {
			CommDaoImpl commDaoImpl = new CommDaoImpl();
			String commId = req.getParameter("commId");
			res = commDaoImpl.delete(commId);
			Answer answer = answerDaoImpl.getAnswer(answerId);
			int comCount = answer.getComCount();
			System.out.println("comCount:"+comCount);
			
			if (comCount>0) {
				comCount--;
				answer.setComCount(comCount);
				answerDaoImpl.updateAnswer(answer);
			}
			res1 = dynaDaoImpl.deleteByOtherId(answerId);
			//再删除动态表中数据
			if (res!=0&&res1!=0) {
			
				writer.write("<script>alert('删除评论成功！')</script>");
			}
			resp.setHeader("refresh", "0;url = FindDetailServlet?topId="+topId);
		}
		
		
		
		
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}

}
