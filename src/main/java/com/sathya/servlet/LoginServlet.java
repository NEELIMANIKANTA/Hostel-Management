package com.sathya.servlet;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		 UserDao dao =new UserDao();
		 User res = dao.findDetails(username);
		 if (res == null) {
		        // If user does not exist, forward back to login page with message
		        int userNotFound = 1;
		        request.setAttribute("userNotFound", userNotFound);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		        dispatcher.forward(request, response);
		        return; // Return to prevent further execution of code
		    }
		
		 int luxuryRooms=new UserDao().getAvailableRooms("Luxury");
		 int deluxeRooms=new UserDao().getAvailableRooms("Deluxe");
		 int normalRooms=new UserDao().getAvailableRooms("Normal");
		 
//		 response.setContentType("text/html");
//		 PrintWriter writer = response.getWriter();
//		 writer.println("<html><body>");
//		 writer.println("luxuryRooms"+luxuryRooms);
//		 writer.println("deluxeRooms"+deluxeRooms);
//		 writer.println("normalRooms"+normalRooms);
//		 
		 //it holds the value until the whole session ends 
		 HttpSession session = request.getSession();
		 session.setAttribute("username", username);
		 	session.setAttribute("deluxeRooms", deluxeRooms);
		 	session.setAttribute("luxuryRooms", luxuryRooms);
		 	session.setAttribute("normalRooms", normalRooms);
		 	
		 	if(res != null &&  res.getUserName().equals(username) && res.getPassword().equals(password))
			 {
		 		RequestDispatcher dispatcher = request.getRequestDispatcher("Home.html");
				dispatcher.forward(request, response);
			 }
//		 	else if(re)
//		 	{
//		 		int userres=1;
//			 	request.setAttribute("userres", userres);
//				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//				dispatcher.forward(request, response);
//		 	}
		 	else
		 	{
		 		int pass=1;
			 	request.setAttribute("passresult", pass);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
		 	}
	}

}
