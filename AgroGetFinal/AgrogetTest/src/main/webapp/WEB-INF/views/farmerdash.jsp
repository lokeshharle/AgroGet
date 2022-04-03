<%@ page import="com.agroget.entity.FarmerEntity"%>
<%@page import="com.agroget.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filling Farmer Details : </title>
</head>
<body>

		welcome user
		 <br/>
		 <br/>

<%
	FarmerEntity farmerEntity = (FarmerEntity)request.getAttribute("farmer");
%>

	
<table border="2">
<tr><td><%=farmerEntity.getFarmerId() %></td></tr>
<tr><td><%=farmerEntity.getFarmerFname() %></td></tr>
<tr><td><%=farmerEntity.getFarmerLname() %></td></tr>
<tr><td><%=farmerEntity.getFarmerMobile() %></td></tr>
<tr><td><%=farmerEntity.getFarmerEmail() %></td></tr>
<tr><td><%=farmerEntity.getFarmerUsername() %></td></tr>
<tr><td><%=farmerEntity.getFarmerPassword() %></td></tr>
<tr><td><%=farmerEntity.getFarmerAddress() %></td></tr>
<tr><td><%=farmerEntity.getFarmerPincode() %></td></tr>
</table>

<a href="editfarmerprofilet?farmerid=<%=farmerEntity.getFarmerId() %>">Edit Profile</a>
<br/>
<a href="showorder?farmerid=<%=farmerEntity.getFarmerId() %>">Show Orders</a>
<br/>
<a href="srch?farmerid=<%=farmerEntity.getFarmerId() %>">Search Equipment</a>
</br>
<a href="logout">logout</a>







</body>
</html>