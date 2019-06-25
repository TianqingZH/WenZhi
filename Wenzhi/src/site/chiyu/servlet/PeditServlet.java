package site.chiyu.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import site.chiyu.bean.Member;
import site.chiyu.dao.impl.MemberDaoImpl;

public class PeditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String basePath = "D:\\gitProjects\\youliao\\WenZhi\\Wenzhi\\WebContent\\img\\tx";
        
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		String nickName = req.getParameter("nickname");
		System.out.println("nickname"+nickName);
		String sex = req.getParameter("sex");
		String sig = req.getParameter("sig");
		String pass = req.getParameter("pass");
		System.out.println("pass:"+pass);
		PrintWriter writer = resp.getWriter();
		System.out.println("basePath");
		File txFile = new File(basePath+"\\"+loginMember.getTx());
		int flag = 0;
		
		
//		int flag = memberDaoImpl.updateMember(loginMember);
		
		//上传头像功能
		FileItemFactory factory = new DiskFileItemFactory();
		 
         // 创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
 
         // 开始解析请求信息
        List<?> items = null;
        try {
             items = upload.parseRequest(req);
         }
         catch (FileUploadException e) {
             e.printStackTrace();
         }
 
         // 对所有请求信息进行判断
         Iterator<?> iter = items.iterator();
         
         while (iter.hasNext()) {
             FileItem item = (FileItem) iter.next();
             // 信息为普通的格式
             if (item.isFormField()) {
                 String fieldName = item.getFieldName();
                 System.out.println("空吗:"+item.getString("UTF-8"));
                 if (!((item.getString("UTF-8")).equals(""))) {
					
				
                 if (fieldName.equals("nickname")) {
					loginMember.setNickname(item.getString("UTF-8"));
					System.out.println(item.getString("UTF-8"));
				}
                if (fieldName.equals("sig")) {
 					loginMember.setSig(item.getString("UTF-8"));
 				}
                if (fieldName.equals("sex")) {
					loginMember.setSex(item.getString("UTF-8"));
				}
                if (fieldName.equals("pass")) {
					loginMember.setPass(item.getString("UTF-8"));
					
				}
                 } 
             }
             // 信息为文件格式
             else {
            	 if (!(item.getName().equals(""))) {
                 String fileName = item.getName();
                 System.out.println(fileName);
                 int index = fileName.lastIndexOf(".");
                 fileName = fileName.substring(index + 1);
                 System.out.println(fileName);
                 fileName = loginMember.getMemId()+(System.currentTimeMillis() / 1000)+"."+fileName;
                 System.out.println(fileName);
                 
 
                 System.out.println("realPath:"+System.getProperty("user.dir"));
                 System.out.println("basePath"+basePath);
                 //File fileTomcat = new File(session.getServletContext().getRealPath("img\\tx"));
                 txFile.delete();
                 loginMember.setTx(fileName);
                 File file = new File(basePath, fileName);
                 try {
                     item.write(file);
                   //  item.write(fileTomcat);
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
             }
            
             }   
         }
         flag =  memberDaoImpl.updateMember(loginMember);
         
         writer.write("<script>alert('保存成功')</script>");
		
         
			
		
         
         resp.setHeader("refresh", "2;FindPersonServlet?CurrentmemId="+loginMember.getMemId());
      
	}

	

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}

}
