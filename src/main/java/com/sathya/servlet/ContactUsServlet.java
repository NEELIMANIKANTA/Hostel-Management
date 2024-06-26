package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContactUsServlet")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		long mobile= Long.parseLong(request.getParameter("mobile"));
		String comments = request.getParameter("comments");
		
		User user =new User();
		user.setName(name);
		user.setMobile(mobile);
		user.setComments(comments);
		
		UserDao dao = new UserDao();
		int result = dao.contactUsDetails(user);
		
		if(result==1)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("contactussubmit.html");
			dispatcher.forward(request, response);
		}
		
	}

}
