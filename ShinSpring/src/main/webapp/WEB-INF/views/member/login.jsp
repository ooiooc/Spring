<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/myapp/member/loginPost" method="post">
	<h3>로그인</h3>
	<table>
	
	<tr>
		<td>ID</td>
		<td><input type="text" name="userid"></td>
	</tr>
	<tr>
		<td>PASSWORD</td>
		<td><input type="password" name="userpw"></td>
	</tr>
	
	<tr>
		<td colspan="2">
		<input type="submit" value="로그인">
		</td>
	</tr>
	
	</table>
	</form>
</body>
</html>