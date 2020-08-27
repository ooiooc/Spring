<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script></head>
<script type="text/javascript" src="../resources/js/register.js"></script></head>
<link rel="stylesheet" type="text/css" href="../resources/css/register.css"/>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

</head>
<body>
		
	
	<h1>게시판 글쓰기 화면 ${result}</h1>

	<form role="form" action="/myapp/board/register" method="post">
	<table>
	<tr>
	 	<td class="title">제목 :</td> 
	 	<td><input type="text" name="title"/></td>
	</tr>
	 
	<tr>
	 	<td class="title">내용 : </td> 
	 	<td><textarea rows="" cols="" name="content"></textarea></td>
	 </tr>	
	  
	<tr>
	  	<td class="title">작성자 : </td> 
	 	<td><input type="text" name="writer"/></td> 
	</tr>
	 
	<tr>
	 	<td class="textbox" colspan="2">
		<input type="submit" value="글쓰기"/></td>
	</tr>
	</table>
	 

 	</form>
 	 
 	<!-- 파일 업로드 drag&drop -->
	<div class="fileDrop">파일 업로드 영역
	</div>
	
	<!-- 파일 업로드 결과 확인-->
	<div class="uploadResult">
	<ul>
	
	</ul>
	</div>
	
	<!-- 확인용 
	<div class="uploadResult1">
	<ul>
	
	</ul>
	</div>-->
</body>
</html>