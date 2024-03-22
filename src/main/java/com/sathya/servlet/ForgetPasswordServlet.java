package com.sathya.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathya.servlet.ConfirmBookingServlet.SMTPAuthenticator;

@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 final String senderEmailId = "manikantaneeli05";
	    final String senderPassword = "kpsc oyqt htix lcpa";
	    final String emailSMTPserver = "smtp.gmail.com";
	    final String emailServerPort = "465";

	    static String emailSubject = "Booking Details";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		UserDao dao = new UserDao();
		User user = dao.findDetailsForgetPass(username);
		
		 if (user == null) {
		        // If user does not exist, forward back to login page with message
		        int userNotFound = 1;
		        request.setAttribute("userNotFound", userNotFound);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		        dispatcher.forward(request, response);
		        return; // Return to prevent further execution of code
		   }
		 String RecieverEmailId = user.getEmail();
		 String emailBody = "Your PassWord is:\n"+"PassWord: " +user.getPassword();
		 
			
		 Properties props = new Properties();
	        props.put("mail.smtp.user", senderEmailId);
	        props.put("mail.smtp.host", emailSMTPserver);
	        props.put("mail.smtp.port", emailServerPort);
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.socketFactory.port", emailServerPort);
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "false");

	        try {
	            SMTPAuthenticator auth = new SMTPAuthenticator();
	            Session session = Session.getInstance(props, auth);
	            MimeMessage msg = new MimeMessage(session);
	            msg.setText(emailBody);
	            msg.setSubject("Booking details");
	            msg.setFrom(new InternetAddress(senderEmailId));
	            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(RecieverEmailId));
	            Transport.send(msg);
	            System.out.println("Message Sent Successfully");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher("passwordSend.html");
	        dispatcher.forward(request, response);
	        
	        
	}
    public class SMTPAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmailId, senderPassword);
        }
    }
		
		
}
