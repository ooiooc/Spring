<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" >

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 화면입니다 :D</h1>
	
	<form action="/myapp/board/modify" method="post"> <!-- modify controller로 이동 -->
	
	<input type="hidden" name="bno" value="${modify.bno}">
	<input type="text" name="pageNum" value="${cri.pageNum}"><br>
	 제목 : <input type="text" name="title" value="${modify.title}"> <br>
	 내용 : <textarea rows="" cols="" name="content" >${modify.content}</textarea><br>
			<!-- textarea는 value속성이 없으므로 따로 빼서 추가하기 --> 
	 작성자 : <input type="text" name="writer" value="${modify.writer}" readonly><br>
	 		<!-- 작성자는 바뀌지 않도록 readonly 읽기전용으로 -->
	
	<input type="submit" value="글 수정">
	
	</form>
	
</body>
</html>