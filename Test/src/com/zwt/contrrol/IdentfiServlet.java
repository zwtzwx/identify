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
		 * ��������������֤��
		 */
		String change = request.getParameter("change");
		if(change != null) {
			request.getRequestDispatcher("out.jsp").forward(request, response);
		}else {
		
		
			//������֤���Ƿ�ƥ��
			
			//��ö�̬���ɵ���֤��
			String hideword = request.getParameter("hideword");
			//����������֤��
			String word = request.getParameter("word");
			
			if(word.equals(hideword)) {
				//��֤�ɹ�
				//��ת����ӭ����
				response.sendRedirect("welcom.jsp");
			}else {
				//��֤ʧ�ܷ�����֤����,ͬʱ����out.jsp��֤ʧ��
				
				request.getRequestDispatcher("out.jsp?type=1").forward(request, response);
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
