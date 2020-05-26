<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OWNERS</title>
</head>
<body>
<table>
<tr>
	<thead>
     <tr style="font-weight:bold; " bgcolor="lightblue"> 
        <td>Id</td> 
        <td>FirstName</td>
        <td>LastName</td>
     </tr>
     </thead>
</tr>
<c:forEach var="owners" items="${owners}" varStatus="status">
 <tr bgcolor=${status.index % 2 == 0?'white':'lightgray'} >
    <td>${owners.id} </td> <td>${owners.firstName} </td> <td>${owners.lastName } </td> 
 </tr>
  </c:forEach> 
</table>

	<c:if test="${not empty message}">
		<div style="color: blue;"> 
			${message}
		</div>
	</c:if>
	
	
	
</body>
</html>