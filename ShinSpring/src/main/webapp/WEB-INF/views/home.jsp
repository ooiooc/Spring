<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="UTF-8">
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
	
 	<%-- The time on the server is ${serverTime}. --%>
	<p>${str}</p>
	<p>${login.username}님 환영합니다</p>
	
</body>
</html>
