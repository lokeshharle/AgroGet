<%@page import="com.agroget.entity.EquipmentInfoTable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.agroget.*"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<EquipmentInfoTable> equipments = (List<EquipmentInfoTable>) request.getAttribute("equipments");
	for(EquipmentInfoTable equipment : equipments )
	{
		%>
			<%= equipment.getEquipment_name() %>
			<%= equipment.getEquipment_rate() %>
			<a href="/orderEquipment?id=<%=equipment.getEquipment_id()%>"> Order Equipment</a>
			</br>
		<%
	}
%>





</body>
</html>