<%@page import="com.agroget.entity.EquipmentInfoTable"%>
<%@page import="com.agroget.entity.FarmerEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	// rename this and use actual gveorder we are trying to use model on gveorder

	give order here
	<%
			FarmerEntity farmerEntity = (FarmerEntity)session.getAttribute("farmer");
			EquipmentInfoTable equipment = (EquipmentInfoTable)request.getAttribute("equipment");
			
	%>
	<h1><%= farmerEntity.getFarmerFname()%></h1>
	<p> <%=equipment.getEquipment_name() %>   </p>
	<p> <%=equipment.getEquipment_type() %>   </p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	<p> <%=equipment.getEquipment_rate_type() %>   </p>
	<p> <%=equipment.getEquipment_rate() %>   </p>
	
	<form action="cnfrmord" method="post">
	
	<label for="fromdate">From Date :</label><br>
	<input type="date" id="fromdate" name="fromdate"><br>
  
   <label for="todate">To Date :</label><br>
   <input type="date" id="todate" name="todate" ><br>
  
   <label for="fromtime">From Time :</label><br>
	<input type="time" id="fromtime" name="fromtime"><br>
  
   <label for="totime">To Time :</label><br>
   <input type="time" id="totime" name="totime" ><br>
   
   <label for="address">Service Address :</label><br>
   <input type="text" id="address" name="address" ><br>
  
  <input type="hidden" value=<%=farmerEntity.getFarmerId()%> name="farmerid" id="farmerid"   />
  <input type="hidden" value=<%=equipment.getEquipment_id()%> name="equipmentid" id="equipmentid"   />
  
  <input type="submit" value="Submit">
  </form>
	


</body>
</html>