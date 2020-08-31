<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/member.js"></script>
<script type="text/javascript" src="../resources/js/ajaxtest.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../resources/css/member.css">
</head>
<body>
	
	<h2>회원가입</h2>
	
	<!-- action에 controller mapping 주소 넣기-->
	<form action="member" method="post">
	<table>
		<tr>
			<td><label>아이디</label><br>
			<input type="text" name="userid"></td>
		</tr>
		
		<tr>
			<td><label>비밀번호</label><br>
			<input type="password" name="userpw"></td>
		</tr> 
		
		<tr>
			<td><label>비밀번호 재확인</label><br>
			<input type="password"></td>
		</tr> 
		
		<tr>
			<td><label>이름</label><br>
			<input type="text" name="username"></td>
		</tr>
		
		<tr>
			<td><label>email</label><br>
			<input type="text" name="email"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="회원가입"></td>
		</tr>
	
	</table>
	</form>
	
	
</body>
</html>