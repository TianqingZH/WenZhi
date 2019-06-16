package site.chiyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 登录权限控制，防止用户未登录越权
 * @author HOME
 *
 */
public class RightFilter implements Filter {



	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest hsRequest = (HttpServletRequest)request;
			HttpServletResponse hsResponse = (HttpServletResponse)response;
			
			String memId = (String) hsRequest.getSession().getAttribute("memId");
			String path = (String)hsRequest.getServletPath();
			System.out.println(path);
			if ((memId ==null|| "".equals(memId))&&((!"/login.jsp".equals(path))&&(!"/register.jsp".equals(path)))) {
				PrintWriter writer = hsResponse.getWriter();
				writer.write("<script>alert('Please Login!')</script>");
				hsResponse.setHeader("refresh", "1;url=login.jsp");
				return;
			}else {
				chain.doFilter(hsRequest, hsResponse);
				return;
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自动生成的方法存根
		
	}

}
