<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filling Farmer Details : </title>
</head>
<body>

<form action="addFarmer1" method="post" enctype="multipart/form-data">
  
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="fname" ><br>
  
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname" ><br>
  
  <label for="mobile">Mobile No:</label><br>
  <input type="text" id="mobile" name="mobile" ><br>
  
  <label for="email">Email :</label><br>
  <input type="text" id="email" name="email" ><br>
  Email will be used as user name for logging in
  <br>
  
  <label for="password">Password :</label><br>
  <input type="text" id="password" name="password" ><br>
  
   <label for="address">Address :</label><br>
  <input type="text" id="address" name="address" ><br>
  
   <label for="pincode">PinCode :</label><br>
  <input type="text" id="pincode" name="pincode" ><br><br>
  
   <label for="file">Insert Image :</label><br>
  <input type="file" id="file" name="file" accept="image/png , image/jpeg" ><br><br>
  
  <input type="submit" value="Submit">
</form> 



</body>
</html>