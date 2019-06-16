package site.chiyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private static final long serialVersionUID = -3951105455705223945L;

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
			System.out.println("memId:"+member.getMemId());
			//判断密码是否正确
			if (password.equals(member.getPass())) {
				System.out.println("正确");
				req.getRequestDispatcher("index.jsp").forward(req, resp);;
			}
			else {
				System.out.println("错误");
				printWriter.write("<script>alert('error Password!')</script>");
				resp.setHeader("refresh", "3;url=login.jsp");
			}
			
		}else {
			System.out.println("错我");
			printWriter.write("<script>alert('NOT FOUND!')</script>");
			resp.setHeader("refresh", "3;url=login.jsp");
		}
		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	
	
}
