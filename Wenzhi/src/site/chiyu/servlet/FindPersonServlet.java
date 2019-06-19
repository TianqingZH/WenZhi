package site.chiyu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Dyna;
import site.chiyu.bean.Member;
import site.chiyu.bean.Topic;
import site.chiyu.dao.impl.AnswerDaoImpl;
import site.chiyu.dao.impl.DynaDaoImpl;
import site.chiyu.dao.impl.MemberDaoImpl;
import site.chiyu.dao.impl.TopicDaoImpl;

public class FindPersonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String currentmemId = req.getParameter("CurrentmemId");
		String memId = req.getParameter("memId");
		Member member = null;
		DynaDaoImpl dynaDaoImpl = new DynaDaoImpl();
		Dyna dyna = null;
		Answer answer = null;
		Topic topic = null;
		List<Dyna> dynaList = null;
		List<Object> list = new ArrayList<Object>();
		HttpSession session = req.getSession();
		if (currentmemId.equals(memId)) {
			member = (Member) session.getAttribute("loginMember");
			session.setAttribute("CurrentMember", member);
		}
		else {
			member = new MemberDaoImpl().getMember(currentmemId);
			session.setAttribute("CurrentMember", member);
		}
		
		dynaList = dynaDaoImpl.listWithMemId(member.getMemId());
		
		if (dynaList.size()>0) {
			for (int i = 0; i < dynaList.size(); i++) {
				dyna = dynaList.get(i);
				//flag==0||1，赞同了回答或评论了回答
				if (dyna.getFlag().equals("0")||dyna.getFlag().equals("1")) {
					answer = new AnswerDaoImpl().getAnswer(dyna.getotherId());
					if (dyna.getFlag().equals("0")) {
						list.add("Answer|0");
						list.add(answer);
					}else {
						list.add("Answer|1");
						list.add(answer);
					}
					
				}
				//flag==3，回答了主题
				else {
					topic = new TopicDaoImpl().getTopic(dyna.getotherId());
					list.add("Topic");
					list.add(topic);
				}
				
			}
		}
		//当前所点击的用户状态全部放进去
		session.setAttribute("Dyna", list);
		
		resp.setHeader("refresh", "0;url=person.jsp");
		
		
			//Member loginMember = (Member)session.getAttribute("loginMember");
			
	
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}
	
	
	

}
