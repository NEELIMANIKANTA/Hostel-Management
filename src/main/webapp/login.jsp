<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<script src="register_validations.js"></script>
<title>LogIn</title>
</head>
<body>
	<div>
		<s:if test="${registerResult==1}">
		<h2 class="text-center text-success">Registration successful Now LogIn....</h2>
		</s:if>
	</div>
	
	<div class="container">
        <h2>User Login</h2>
        <form method="post" action="LoginServlet" enctype="multipart/form-data" onsubmit="return loginValidations()">
        	
			
            <div class="form-group">
                <label for="username" class="form-label">UserName:</label>
                <input type="text" name="username" id="username" class="form-control" placeholder="Enter username" required>
            </div>
            <div class="form-group">
                <label for="password" class="form-label">Password:</label>
                <input type="password" name="password" id="password" class="form-control" placeholder="Enter password" required>
           </div>
           <div>
				<s:if test="${passresult==1}">
				<h6 class="text-center text-danger">Password is Inavalid....</h6>
				</s:if>
			</div>
			<div>
				<s:if test="${userNotFound==1}">
				<h6 class="text-center text-danger">Username is Invalid Please Register...</h6>
				</s:if>
			</div>
			
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
            <div style="text-align: center">
				<a href="forgetpassword.html" class="text-center">forget password?</a>
			</div>
            
             <div class="already-registered">
    			<p>New To Hostel? <a href="register.html">Register Here</a></p>
			</div>
        </form>
    </div>
</body>
</html>