<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
    <%@page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<script src="register_validations.js"></script>
<title>Book Rooms</title>
</head>
<style>
	.form-group label {
    font-weight: bold;
}
</style>
<body>
    <div class="container mt-5">
        <form method="post" action="BookingInvoiceServlet" class="col-md-6 mx-auto" enctype="multipart/form-data" onsubmit="return BookingValidations()">
        	<div class="form-group">
        		<%-- Retrieve the session attribute named "username" --%>
    				<% String username = (String) session.getAttribute("username"); %>
        		<label>User Name:</label>
        		<input type="text" name="userName" id="userName" 
        		class="form-control" value="${username}" required> 
        	</div>
        	<div class="form-group">
        		<label>Book Room:</label>
        		<input type="text" name="bookRoom" id="bookRoom" 
        		class="form-control" value="${userBookDetails.category}" required> 
        	</div>
        	<div class="form-group">
        		<label>Available Rooms:</label>
        		<input type="number" name="AvailableRooms" id="AvailableRooms" 
        		class="form-control" value="${userBookDetails.rooms_Available}" required> 
        	</div>
        	<div class="form-group">
        		<label>Pricing:</label>
        		<input type="number" name="pricing" id="pricing" 
        		class="form-control" value="${userBookDetails.pricing}" required> 
        	</div>
            
            <div class="form-group">
                <label for="checkIn">Check In Date:</label>
                <input type="date" name="checkIn" id="checkIn" class="form-control" value="<%= java.time.LocalDate.now() %>" required>
            </div>
            
            <div class="form-group">
                <label for="checkOut">Check Out Date:</label>
                <input type="date" name="checkOut" id="checkOut" class="form-control" required>
            </div>
            
            <div class="form-group">
                <label for="adhaarNum">Upload Adhaar:</label>
                <input type="file" name="adhaar" id="adhaar" class="form-control" accept="image/*" required>
            </div>
            <div class="form-group">
				<input type="submit" value="Confirm Booking" class="btn btn-primary btn-block">
			</div>
            
            
        </form>
    </div>
</body>
</html>