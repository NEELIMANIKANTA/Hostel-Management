function registerValidations() {
    var name = document.getElementById("name").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmpassword").value;
    var email = document.getElementById("email").value;
    var mobile = document.getElementById("mobile").value;
    var address = document.getElementById("address").value;
    var username = document.getElementById("userName").value;

    // Password and confirm password checking
    if (name.trim() === "" || password.trim() === "" || confirmPassword.trim() === "" || email.trim() === "" || mobile.trim() === "" || address.trim() === "") {
        alert("Please enter all values");
        return false;
    }
    if(username.length > 50) {
        alert("Username length must be below 50 characters");
        return false;
    }
    if (password !== confirmPassword) {
        alert("Password and confirm password must be the same");
        return false;
    }

    // Password strength check (example: minimum 8 characters, one uppercase letter, and one special character)
    if (password.length <8) {
        alert("Password must be at least 8 characters long");
        return false;
    }
    if (!/[A-Z]/.test(password)) {
        alert("Password must contain at least one uppercase letter");
        return false;
    }
    if (!/[!@#$%^&*]/.test(password)) {
        alert("Password must contain at least one special character");
        return false;
    }


    // Email format validation using regular expression
    var emailRegex = /^[^\s@]+@gmail\.com$/;
	if (!emailRegex.test(email)) {
    alert("Enter a valid Gmail address");
    return false;
}

    // Mobile number length check
    if (mobile.length !== 10) {
        alert("Mobile number must be 10 digits long");
        return false;
    }

    return true; 
    }

function loginValidations() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // Validate the username and password
    if (username.trim() === "" || password.trim() === "") {
        alert("Please enter all values");
        return false;
    }

    if (username.length > 50) {
        alert("Username must be below 50 characters");
        return false;
    }
    
    return true; // Return true if all validations pass
}

function BookingValidations() {
    // Get form inputs
    const username = document.getElementById("userName").value;
    const bookRoom = document.getElementById("bookRoom").value;
    const availableRooms = document.getElementById("AvailableRooms").value;
    const pricing = document.getElementById("pricing").value;
    const checkIn = document.getElementById("checkIn").value;
    const checkOut = document.getElementById("checkOut").value;
    const adhaar = document.getElementById("adhaar").value;

    if (username.trim() ==="" || bookRoom.trim() === "" || availableRooms.trim() === "" || pricing.trim() === "" || checkIn.trim() === "" || checkOut.trim() === "" || adhaar.trim() === "") {
        alert("Please fill in all fields.");
        return false;
    }

    const checkinDate = new Date(checkIn);
    const checkoutDate = new Date(checkOut);

    // Compare only dates, not times
    if (checkinDate > checkoutDate) {
        alert("Check-in date must be before check-out date.");
        return false;
    }

    return true;
}



document.getElementById('navbar-toggle').addEventListener('click', function() {
  var navbarMenu = document.getElementById('navbar-menu');
  navbarMenu.classList.toggle('active');
});
