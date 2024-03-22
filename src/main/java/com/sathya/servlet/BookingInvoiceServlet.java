package com.sathya.servlet;

import java.io.IOException; 
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;

@MultipartConfig
@WebServlet("/BookingInvoiceServlet")
public class BookingInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("userName");
		String bookRoom = request.getParameter("bookRoom");
//		int AvailableRooms = Integer.parseInt(request.getParameter("AvailableRooms"));
		double pricing = Double.parseDouble(request.getParameter("pricing"));
		LocalDate checkIn = Date.valueOf(request.getParameter("checkIn")).toLocalDate();
		LocalDate checkOut = Date.valueOf(request.getParameter("checkOut")).toLocalDate();
		Part part = request.getPart("adhaar");
		InputStream inputStream = part.getInputStream();
		byte[] aadharImage = IOUtils.toByteArray(inputStream);
		
		int duration = calculateDaysBetween(checkIn, checkOut);

		double totalrent = duration * pricing;
		double sgst = totalrent * 0.09;
		double cgst = sgst;
		double discount = 0.05 * (totalrent + sgst + cgst);
		double totalPrice = totalrent + sgst + cgst - discount;

		UserDao dao = new UserDao();
		String email = dao.getEmail(username);
		
		User user = new User();
		user.setUserName(username);
		user.setCategory(bookRoom);
		user.setPricing(pricing);
		user.setCheck_in_date(Date.valueOf(checkIn));
		user.setCheck_out_date(Date.valueOf(checkOut));
		user.setDuration(duration);
		user.setTotalrent(totalrent);
		user.setSgst(sgst);
		user.setCgst(cgst);
		user.setDiscount(discount);
		user.setTotalPrice(totalPrice);
		user.setAdhaar(aadharImage);

		UserDao dao2 = new UserDao();
		int count = dao2.saveUserBookingDetails(user);
		
		int res =dao2.updateRooms(bookRoom);
		System.out.println(res);
		int luxuryRooms=new UserDao().getAvailableRooms("Luxury");
		 int deluxeRooms=new UserDao().getAvailableRooms("Deluxe");
		 int normalRooms=new UserDao().getAvailableRooms("Normal");
		 
		 HttpSession session = request.getSession();
		 	session.setAttribute("deluxeRooms", deluxeRooms);
		 	session.setAttribute("luxuryRooms", luxuryRooms);
		 	session.setAttribute("normalRooms", normalRooms);

//		  response.setContentType("text/html"); 
//		  PrintWriter writer =response.getWriter();
//		  writer.println("<html><body>");
//		  writer.println("<h2>UserName:" + username + "</h2>");
//		  writer.println("<h2>checkInDate:" + checkIn + "</h2>");
//		  writer.println("<h2>checkOutDate:" + checkOut + "</h2>");
//		  writer.println("<h2>adhaarNum:" + aadharImage + "</h2>");
//		  writer.println("<h2>price:" + pricing + "</h2>");
//		 writer.println("<h2>type:" + bookRoom + "</h2>"); 
//		 writer.println("<h2>email:" +email + "</h2>"); 
//		 writer.println("<h2>duration:" +duration + "</h2>"); 
//		 writer.println("<h2>sgst:" +sgst + "</h2>"); 
//		 writer.println("<h2>cgst:" +cgst + "</h2>"); 
//		 writer.println("<h2>discount:" +discount + "</h2>"); 
//		 writer.println("<h2>total price:" +totalPrice + "</h2>"); 
//		 writer.println("</body></html>");
	if(count==1)
	{
		request.setAttribute("username",username);
		request.setAttribute("email", email);
		request.setAttribute("RoomType", bookRoom);
		request.setAttribute("rentPerDay", pricing);
		request.setAttribute("checkInDate", checkIn);
		request.setAttribute("checkOutDate", checkOut);
		request.setAttribute("duration", duration);
		request.setAttribute("totalRent", totalrent);
		request.setAttribute("cgst", cgst);
		request.setAttribute("sgst", sgst);
		request.setAttribute("discount", discount);
		request.setAttribute("totalPrice", totalPrice);

		RequestDispatcher dispatcher1=request.getRequestDispatcher("billing.jsp");
		dispatcher1.forward(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmBookingServlet");
		dispatcher.include(request, response);
	
	}
	else
	{ 
		  response.setContentType("text/html"); 
		  PrintWriter writer =response.getWriter();
		  writer.println("<html><body>");
		  writer.println("<h2> check the details...</h2>");
		  writer.println("<h2>Booking Failed....</h2>");
		  writer.println("</body></html>");
		  RequestDispatcher dispatcher1=request.getRequestDispatcher("book.jsp");
		  dispatcher1.forward(request, response);
		
	}
	}
	public static int calculateDaysBetween(LocalDate date1, LocalDate date2) {
		// Calculate the difference using ChronoUnit
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		// Return the absolute value to ensure positive number of days
		return (int)Math.abs(daysBetween);
	}

}
