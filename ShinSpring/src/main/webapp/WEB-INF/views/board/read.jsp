<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/read.js"></script>
<script type="text/javascript" src="../resources/js/ajaxtest.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

body {
   font-family: 'Noto Sans KR', sans-serif;
}

/* .replyarea{
	border: 1px solid #000;
} */

table{
	border-collapse: collapse;
	border: 1px solid #000;
}

</style>

</head>

<body>
	
	<div id="modDiv">
		<div class="modal-title"></div>
		<div><input type="text" id="replytext"></div>
		<div>
			<button type="button" id="replyModBtn">수정</button>
			<button type="button" id="replyDelBtn">삭제</button>
			<button type="button" id="closeBtn">닫기</button>
		</div>
	</div>	
	
	<form role="form" >
	
	<input type="hidden" name="bno" id="bno" value="${read.bno}">
	<input type="text" name="pageNum" value="${cri.pageNum}">
	
	<table border="1" width="400" style="text-align:center">
		<tr>
			<td colspan="2">${read.title}</td>
		</tr>
		
		<tr>
			<td>${read.writer}</td>
			<td>${read.viewcnt}</td>
		</tr>
		
		<tr>
			<td colspan="2">${read.content}</td>
		</tr>
		
		<tr>
			<td colspan="2">
			<button type="submit" class="btn-warning">수정</button>
			<button type="submit" class="btn-danger">삭제</button>
			<button type="submit" class="btn-primary">목록</button>
			</td>
		</tr>
	
		<tr>
		<!-- 댓글 설정 -->
			<td colspan="2">
			<ul id="replies">
			</ul>
			</td>
		</tr>
		
		<tr>
			<td>
			작성자 <input type="text" name="replyer" id="newReplyWriter"><br>
			댓글내용 <input type="text" name="replytext" id="newReplyText"></td>
			
			<td><button id="replyAddBtn">댓글 등록</button></td>
			
		</tr>
		<tr>
			<td colspan="2">
			<ul id="replyPage">
			</ul></td>
		</tr>
	</table>	
		
	
	</form>
</body>
</html>