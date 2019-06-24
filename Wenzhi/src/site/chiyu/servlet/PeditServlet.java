package site.chiyu.servlet;

import java.io.File;
import java.io.IOException;
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

public class PeditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		String nickName = req.getParameter("nickname");
		String sex = req.getParameter("sex");
		String sig = req.getParameter("sig");
		String basePath = session.getServletContext().getRealPath("/img");
		System.out.println("basePath");
		FileItemFactory factory = new DiskFileItemFactory();
		 
         // 创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
 
         // 开始解析请求信息
        List items = null;
        try {
             items = upload.parseRequest(req);
         }
         catch (FileUploadException e) {
             e.printStackTrace();
         }
 
         // 对所有请求信息进行判断
         Iterator iter = items.iterator();
         while (iter.hasNext()) {
             FileItem item = (FileItem) iter.next();
             // 信息为普通的格式
             if (item.isFormField()) {
                 String fieldName = item.getFieldName();
                 String value = item.getString();
                 req.setAttribute(fieldName, value);
             }
             // 信息为文件格式
             else {
                 String fileName = item.getName();
                 System.out.println(fileName);
                 int index = fileName.lastIndexOf("\\");
                 fileName = fileName.substring(index + 1);
                 req.setAttribute("realFileName", fileName);
 
                 String basePath = req.getRealPath("/images");
                 File file = new File(basePath, fileName);
                 try {
                     item.write(file);
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
             }
             req.setAttribute("msg","文件上传成功!");
             
         }
	}

	

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doPost(arg0, arg1);
	}

}
