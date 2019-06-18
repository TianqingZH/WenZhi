package site.chiyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Member;
import site.chiyu.bean.Topic;
import site.chiyu.dao.impl.AnswerDaoImpl;
import site.chiyu.dao.impl.MemberDaoImpl;
import site.chiyu.dao.impl.TopicDaoImpl;

public class FindIndexServlet extends HttpServlet {
	List<Topic> topList = null;
	List<Answer> ansList = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("FindServlet");
		Topic topic = null;
		Answer answer = null;
		AnswerDaoImpl answerDaoImpl = new AnswerDaoImpl();
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		String topCon = "";
		String ansCon = "";
		String memId ="";
		Map<String, String> map = new HashMap<String, String>();
		Map<String , Member> mebMap = new HashMap<>();
		topList = new TopicDaoImpl().list();
		
		for (int i = 0; i < topList.size(); i++) {
			int j = 0;
			topic = topList.get(i);
			topCon = topic.getTopCon();
			System.out.println("topId"+topic.getTopId());
			ansList = answerDaoImpl.listWithTopId(topic.getTopId());
			System.out.println("size:"+ansList.size());
			System.out.println("ansList:"+ansList.toString());
			//该话题下有回答
			if (ansList.size()>0) {
				ansCon = ansList.get(j).getAnsCon();
				memId = ansList.get(j).getMemId();
				mebMap.put(ansCon, memberDaoImpl.getMember(memId));
				
			}else {
				ansCon = "还没有回答！";
			}
			map.put(topCon, ansCon);
		
		}
		
		req.getSession().setAttribute("map", map);
		req.getSession().setAttribute("mebMap", mebMap);
		resp.setHeader("refresh", "0;url=index.jsp");
//		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}

}
