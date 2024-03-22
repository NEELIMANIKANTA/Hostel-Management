package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String email = request.getParameter("email");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		String address = request.getParameter("address");
		
		User user = new User();
		user.setUserName(username);
		user.setName(name);
		user.setPassword(password);
		user.setConfirmpassword(confirmpassword);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setAddress(address);
		
		UserDao dao = new UserDao();
		int result = dao.save(user);
		
		if(result==1)
		{
			request.setAttribute("registerResult", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<html><body>");
			writer.println("<h2>Registartion Failed....</h2>");
			writer.println("<h2>User Name change please...</h2>");
			writer.println("</body></html>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.html");
			dispatcher.forward(request, response);
		}
	}

}
