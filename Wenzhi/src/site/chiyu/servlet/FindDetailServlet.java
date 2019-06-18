package site.chiyu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Comm;
import site.chiyu.bean.Member;
import site.chiyu.bean.Topic;
import site.chiyu.dao.impl.AnswerDaoImpl;
import site.chiyu.dao.impl.CommDaoImpl;
import site.chiyu.dao.impl.MemberDaoImpl;
import site.chiyu.dao.impl.TopicDaoImpl;

public class FindDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Topic topic = null;
		Answer answer  = null;
		Comm comm = null;
		AnswerDaoImpl answerDaoImpl = new AnswerDaoImpl();
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		CommDaoImpl commDaoImpl = new CommDaoImpl();
		Map<Member,Answer > mapMemAndAns = new HashMap<Member, Answer>();
		Map<Member, Comm> mapMemAndComm = new HashMap<>();
		List<Answer> ansList = null;
		List<Comm> commList = null;
		HttpSession session = req.getSession();
		String topId = req.getParameter("topId");
		System.out.println("topId"+topId);
		
		//得到话题对象
		topic = new TopicDaoImpl().getTopic(topId);
		
		ansList = answerDaoImpl.listWithTopId(topId);
		
		//如果该问题下有回答
		if(ansList.size()>0){
			for (int i = 0; i < ansList.size(); i++) {
				answer = ansList.get(i);
					commList = commDaoImpl.listWithAnswerId(answer.getAnswerId());
					//该问题下的评论
					if(commList.size()>0){
						for (int j = 0; j < commList.size(); j++) {
							comm = commList.get(j);
							Member member = memberDaoImpl.getMember(comm.getMemId());
							mapMemAndComm.put(member, comm);
						}
					}
				
				Member member = memberDaoImpl.getMember(answer.getMemId());
				mapMemAndAns.put(member, answer);
			}
		}
		
		//将topic放入session中
		session.setAttribute("topic", topic);
		
		//将回答者和答案放置在session中
		session.setAttribute("mapMemAndAns", mapMemAndAns);
		//将回答者和评论放置在session中
		session.setAttribute("mapMemAndComm", mapMemAndComm);
		
		resp.setHeader("refresh", "0;url=detail.jsp");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}

}
