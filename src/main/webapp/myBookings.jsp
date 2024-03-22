<%@page import="com.sathya.servlet.UserDao"%>
<%@page import="java.util.Base64"%>
<%@page import="com.sathya.servlet.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CDN(Content Delivery Network) link to get support of BootStrap -->
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="navstyles.css">
</head>
<body>  
    
    
    <nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
      <a class="navbar-brand" href="Home.html">
        <img src="images/hostel.webp" alt="Logo">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item ">
            <a class="nav-link" href="Home.html">Home</a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="room.jsp">Rooms</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="myBookings.jsp">MY Bookings</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="aboutus.html">About Us</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contactus.html">Contact Us</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="gallery.html">Gallery</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="login.jsp">Logout</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
    <a href="rooms.html" class="btn btn-primary">New Room Booking</a>
    <br>
	<table class="table table-bordered table-striped">
    <thead class="thead-dark">
        <tr>
        	<th>Booking Id</th>
            <th>UserName</th>
            <th>Type of Room</th>
            <th>Price per Day</th>
            <th>CheckIN</th>
            <th>CheckOut</th>
            <th>Duration of Stay</th>
            <th>rent</th>
            <th>sgst</th>
            <th>cgst</th>
            <th>Discount</th>
            <th>Total Price</th>
            <th>Aadhar Image</th>
        </tr>
    </thead>
    <tbody>
    <%
    // Get attribute value
    String username= (String) session.getAttribute("username");
    %>  
        <s:forEach var="user" items="<%=new UserDao().findUSerBookingDetailsByUsername(username)%>" >
            <tr>
            	<td>${user.bookingId}</td>
                <td>${user.userName}</td>
                <td>${user.category}</td>
                <td>${user.pricing}</td>
                <td>${user.check_in_date}</td>
                <td>${user.check_out_date}</td>
                <td>${user.duration}</td>
                <td>${user.totalrent}</td>
                <td>${user.sgst}</td>
                <td>${user.cgst}</td>
                <td>${user.discount}</td>
                <td>${user.totalPrice}</td>
          
                <!-- Display image using img tag -->
                <td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(user.adhaar)}" Style="max-width:100px; max-height:100px;"></td>
               
                <%-- <td>
                	<a href="./DeleteProductServlet?proId=${product.proId}" class="btn btn-primary">Delete</a>
                	<a href="./EditProductServlet?proId=${product.proId}" class="btn btn-primary">Edit</a>
                </td> --%>
            </tr>
        </s:forEach>
    </tbody>
    </table>
</body>
</html>