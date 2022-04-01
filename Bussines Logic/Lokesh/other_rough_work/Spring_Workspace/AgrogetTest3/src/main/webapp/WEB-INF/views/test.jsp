<%@page import="com.agroget.entity.OrderInfoTable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		OrderInfoTable oit = (OrderInfoTable)request.getAttribute("orderInfo");
	%>
			Show Bill
			<h4><%= oit.getOrderId() %></h4>
			<h4><%= oit.getOrderTotalCost() %></h4>
</body>
</html>