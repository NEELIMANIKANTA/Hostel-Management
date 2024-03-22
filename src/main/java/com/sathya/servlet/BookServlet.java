package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value1 = request.getParameter("value1");
	
		
		UserDao dao  = new UserDao();
		User user = dao.findDetailsOfRoom(value1);
		
		request.setAttribute("userBookDetails", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book.jsp");
		dispatcher.forward(request, response);
	
	}

}
