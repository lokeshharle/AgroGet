<%@page import="com.agroget.entity.OrderEquipmentTable"%>
<%@page import="com.agroget.entity.OrderInfoTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br/>
<table border="2">
<%
	List<OrderInfoTable> orderInfoList = (List<OrderInfoTable>) request.getAttribute("orderInfoList");
	for(OrderInfoTable orderInfo : orderInfoList )
	{
		%>
			<tr>
			<td><%= orderInfo.getOrderId()%></td>
			<td><%= orderInfo.getOrderTotalCost()%></td>
			<%-- <td><%= orderInfo.getOrderDate()%></td>
 --%>			</tr>
			</br>
		<%
	}
%>
</table>

<br/>
<table border="2">
<%
	List<OrderEquipmentTable> orderEquipmentList = (List<OrderEquipmentTable>) request.getAttribute("orderEquipmentList");
	for(OrderEquipmentTable orderEquipment : orderEquipmentList )
	{
%>
			<tr>
			<form>
			<td><%= orderEquipment.getOrderEquipmetId()%></td>
			<td><%=orderEquipment.getEquipmentInfoTbl().getEquipment_name() %></td>
			<td><%=orderEquipment.getEquipmentInfoTbl().getEquipment_id() %></td>
			<td><%= orderEquipment.getFromDate()%></td>
			<td><%= orderEquipment.getToDate()%></td>
			<td><a href="/givefeedback">Give Feedback</a></td>
			<td><a href="/enterfeedback?equipmentid=<%=orderEquipment.getEquipmentInfoTbl().getEquipment_id() %>"> Enter Equipment Feedback</a></td>
			<td>
			<input type="submit" value=""></input>
			</form>
			</tr>
			
		<%
	}
%>
</table>




</body>
</html>