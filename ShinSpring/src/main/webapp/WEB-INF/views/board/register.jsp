<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	 <h1>게시판 글쓰기 화면 ${result}</h1>
	 <form action="/myapp/board/register" method="post">
	 제목 : <input type="text" name="title"><br>
	 내용 : <textarea rows="" cols="" name="content"></textarea><br>
	 작성자 : <input type="text" name="writer"><br>
	 
	 <input type="submit" value="글쓰기">
	 </form>

</body>
</html>