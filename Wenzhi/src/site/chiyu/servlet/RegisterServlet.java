package site.chiyu.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.chiyu.bean.Member;
import site.chiyu.dao.impl.MemberDaoImpl;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		String pass  = req.getParameter("pass");
		String nickname = req.getParameter("nickname");
		Member member  = new Member();
		member.setMemId(memId);
		member.setPass(pass);
		member.setNickname(nickname);
		member.setMctime(new Timestamp(new Date().getTime()));
		//member.setSex("男");
		//member.setSig("贺嘉琦要乐观啊");
		//member.setTx("".getBytes());
		int flag = new MemberDaoImpl().add(member);
		System.out.println("flag："+flag);
		if (flag!=0) {
			System.out.println("注册成功！");
		}
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}

}
