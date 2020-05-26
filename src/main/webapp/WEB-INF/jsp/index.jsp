<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Ana Sayfa</title>
</head>
<body>
    <security:authorize access="isAuthenticated()">
    
	<h1> Ana Sayfaya Hoşgeldin   <security:authentication property="principal.username" />       </h1>
	
	
</security:authorize>
	<form action="logout" method="post">
	
		<input type="submit" value="Logout">	
		<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}">	

	</form>
	
</body>
</html>