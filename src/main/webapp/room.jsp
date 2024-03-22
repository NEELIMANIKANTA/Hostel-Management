<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Responsive Navigation Bar</title>
  <!-- Bootstrap CSS -->
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
          <li class="nav-item active">
            <a class="nav-link" href="room.jsp">Rooms</a>
          </li>
          <li class="nav-item">
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
  <div class="container-content">
    <h1>Welcome to our Hostel Sathya!</h1>
    <p style="font-weight: bold; font-size: 18px; color: #555;">Warden: Ratan sir</p>

  </div>

  <!-- Image sections container -->
  <div class="container-fluid image-sections">
    <section class="image-section" style="background-image: url('images/luxary.jpg');">
      <div class="overlay">
        <h2>Luxury Deluxe Room</h2>
        <%
    // Using scriptlets to get the values (alternative method)
    int deluxeRooms = (int) session.getAttribute("deluxeRooms");
    int luxuryRooms = (int) session.getAttribute("luxuryRooms");
    int normalRooms = (int) session.getAttribute("normalRooms");
%>
        <h2 class="text-success">Available rooms:${luxuryRooms}</h2>
        <div>
          <ol>
            <li>Free Wi-Fi</li>
            <li>Smart TV</li>
            <li>Hot Water</li>
            <li>AC</li>
            <li>King Size Bed</li>
          	<li>Delisious Food</li>
            <li>Only Two people for one Room</li>
          </ol>
        </div>
        <h2>Price: Rs.800/day</h2>
        <a href="./BookServlet?value1=Luxury" class="btn btn-primary">BOOK HERE</a>
      </div>
    </section>

    <section class="image-section" style="background-image: url('images/deluxe.jpg');">
      <div class="overlay">
        <h2>Deluxe Room</h2>
        <h2 class="text-success">Available rooms:${deluxeRooms}</h2>
        <div>
          <ol>
            <li>Free Wi-Fi</li>
            <li>Smart TV</li>
            <li>Hot Water</li>
            <li>Iron Bed</li>
            <li>Delisious Food</li>
            <li>Only three people for one Room</li>
          </ol>
        </div>
        <h2>Price: Rs.500/day</h2>
        <a href="./BookServlet?value1=Deluxe" class="btn btn-primary">BOOK HERE</a>
      </div>
    </section>

    <section class="image-section" style="background-image: url('images/normal.jpg');">
      <div class="overlay">
        <h2>Normal Rooms</h2>
        <h2 class="text-success">Available rooms:${normalRooms}</h2>
        <div>
          <ol>
          
            <li>Free Wi-Fi</li>
            <li>Normal rooms</li>
           <li>Hot water</li>
           <li>Delisious Food</li>
            <li>Only Five people for one Room</li>
          </ol>
        </div>
        <h2>Price: Rs.300/day</h2>
        <a href="./BookServlet?value1=Normal" class="btn btn-primary">BOOK HERE</a>
      </div>
    </section>
  </div>
</body>
</html>
