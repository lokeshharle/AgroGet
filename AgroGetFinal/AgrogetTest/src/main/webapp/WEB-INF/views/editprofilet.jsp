<%@ page import="com.agroget.entity.FarmerEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Edit Profile
<br/>

<%
	FarmerEntity farmerEntity = (FarmerEntity)request.getAttribute("farmer");
	System.out.println(farmerEntity.getFarmerFname());
%>

<form action="updatefarmer" method="post">
  
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="fname" value=<%=farmerEntity.getFarmerFname() %> ><br>
  
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname" value=<%=farmerEntity.getFarmerLname() %>><br>
  
  <label for="mobile">Mobile No:</label><br>
  <input type="text" id="mobile" name="mobile" value=<%=farmerEntity.getFarmerMobile() %>><br>
  
  <label for="email">Email :</label><br>
  <input type="text" id="email" name="email" value=<%=farmerEntity.getFarmerEmail() %>>
  <br/>
  Email will be used as user name for logging in
  <br/>
  
  <label for="password">Password :</label><br>
  <input type="text" id="password" name="password" value=<%=farmerEntity.getFarmerPassword() %>><br>
  
   <label for="address">Address :</label><br>
  <input type="text" id="address" name="address" value=<%=farmerEntity.getFarmerAddress() %>  ><br>
  
   <label for="pincode">PinCode :</label><br>
  <input type="text" id="pincode" name="pincode" value=<%=farmerEntity.getFarmerPincode() %>><br><br>
  
  <input type="hidden" value=<%=farmerEntity.getFarmerId()%> name="farmerid" id="farmerid"   />
  
  <input type="submit" value="Submit">
</form> 




</body>
</html>