package com.zwt.contrrol;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/IdentfiServlet")
public class IdentfiServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 处理重新生成验证码
		 */
		String change = request.getParameter("change");
		if(change != null) {
			request.getRequestDispatcher("out.jsp").forward(request, response);
		}else {
		
		
			//处理验证码是否匹配
			
			//获得动态生成的验证码
			String hideword = request.getParameter("hideword");
			//获得输入的验证码
			String word = request.getParameter("word");
			
			if(word.equals(hideword)) {
				//验证成功
				//跳转到欢迎界面
				response.sendRedirect("welcom.jsp");
			}else {
				//验证失败返回验证界面,同时告诉out.jsp验证失败
				
				request.getRequestDispatcher("out.jsp?type=1").forward(request, response);
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
