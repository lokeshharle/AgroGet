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
		Give Feedback here
		<br/>
		
		<%
			FarmerEntity farmerEntity = (FarmerEntity)session.getAttribute("farmer");
		%>
		
		

<form action="test" method="post">
  
  <label for="feedbackrating">Enter Rating</label><br>
  <input type="number" id="feedbackrating" name="feedbackrating" min="1" max="5"><br>
  
  <label for="feedbackcomments">Enter Description</label><br>
  <input type="text" id="feedbackcomments" name="feedbackcomments" ><br>
  
  <input type="hidden" value=<%=farmerEntity.getFarmerId()%> name="farmerid" id="farmerid"   />
  
  <input type="submit" value="Submit">
</form> 
		
</body>
</html>