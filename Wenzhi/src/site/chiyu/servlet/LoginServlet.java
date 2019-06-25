package site.chiyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import site.chiyu.bean.Member;
import site.chiyu.dao.impl.MemberDaoImpl;

/***
 * 登录验证
 * @author HOME
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = null;
		String memId = req.getParameter("memId");
		String password = req.getParameter("pass");
		System.out.println("password:"+password);
		MemberDaoImpl impl = new MemberDaoImpl();
		member = impl.getMember(memId);
		
		PrintWriter printWriter = resp.getWriter();
		System.out.println("member"+member);
		//账号存在
		System.out.println("1");
		//System.out.println("memId"+member.getMemId());
		System.out.println("2");
		if (member != null) {
			String isAdmin = member.getIsAdmin();
			System.out.println("memId:"+member.getMemId());
			//判断密码是否正确
			if (password.equals(member.getPass())) {
				System.out.println("正确");
				HttpSession session = req.getSession();
				session.setAttribute("memId", member.getMemId());
//				session.setAttribute("nickName", member.getNickname());
				session.setAttribute("loginMember", member);
				if ("1".equals(isAdmin)) {
					printWriter.write("<script>alert('欢迎你，管理员！')</script>");
				}
				//req.getRequestDispatcher("FindIndexServlet").forward(req, resp);;
				resp.setHeader("refresh", "0;url = FindIndexServlet");
			}
			else {
				System.out.println("错误");
				printWriter.write("<script>alert('密码输入错误，请检查后重新输入！')</script>");
				resp.setHeader("refresh", "0;url=login.jsp");
			}
			
		}else {
			
			printWriter.write("<script>alert('输入有误或未注册，请检查后重新输入！')</script>");
			resp.setHeader("refresh", "0;url=login.jsp");
		}
		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	
	
}
