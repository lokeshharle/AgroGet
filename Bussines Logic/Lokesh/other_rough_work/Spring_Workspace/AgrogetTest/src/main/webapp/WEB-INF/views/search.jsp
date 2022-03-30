<%@page import="com.agroget.entity.EquipmentInfoTable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.agroget.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="searchme" method="post">
	
	 <select id="type" name="type">
	  	<option value="none" selected disabled hidden>Select an Type</option>
  		<option value="seeding">seeding</option>
  		<option value="crop protection">crop protection</option>
  		<option value="tillage">tillage</option>
  		<option value="harvesting">harvesting</option>
	</select>
  
  		<label for="type">Type :</label><br>
  		<input type="text" id="type" name="type" ><br>
  
  		<input type="submit" value="Submit">
  		
	</form> 

</body>
</html>