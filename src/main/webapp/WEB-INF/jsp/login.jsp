<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN PAGE</title>
</head>
<body>

<h1>PetClinic Login Page</h1>
<form action="login" method="post" >

USERNAME      <input type="text"     name="username">  <br/>
PASSWORD      <input type="password" name="password">  <br/>
REMEMBER ME	  <input type="checkbox" name="remember-me"><br/>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
<input type="submit" value="LOGIN">
</form>

<font color="red">
<c:if test="${not empty param.loginFailed }">
	<c:out value="Login Failed,Incorrect username,password!!!"></c:out>
</c:if>
</font>
</body>
</html>