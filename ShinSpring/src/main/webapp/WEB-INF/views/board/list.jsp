<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl 문법 쓰기 위해 필요한 JSTL core 선언-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/style.css" > -->
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*
*{
	font-family: 'Noto Sans KR', sans-serif;
	margin: 0;
	padding: 0;
}

.wrap{
	border: 1px solid #000;
	margin: 0 auto;
	display: flex;
	justify-content: center;
}

.search{
	display: flex;
	flex-direction: row;
}
*/
</style>

</head>

<body>
<c:choose>
	<c:when test="${msg eq 'SUCCESS!'}">
	<script type="text/javascript">
		alert("수정 되었습니다");
	</script>
	</c:when>
		<c:when test="${msg eq 'DSUCCESS!'}">
			<script type="text/javascript">
			alert("삭제 되었습니다");
			</script>
		</c:when>
</c:choose>

<%-- ${msg} --%> 
	
	<div class="wrap">
	<table border="1" style="text-align:center">
		<tr>
			<td colspan="2">제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<!-- 타이틀란은 반복 x -->
		
		<c:forEach items="${list}" var="board"> <!-- 한 건씩 불러들여서 처리 -->
		<!--위에 있는 list는 model.addAttribute("list", service.listAll());에서의 list이다-->
		
		<tr>
			<td>${board.bno}</td>
			<td><a href="/myapp/board/read?bno=${board.bno}&pageNum=${pageMaker.cri.pageNum}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.regdate}</td>
			<td>${board.viewcnt}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><!-- <input type="submit" value="글쓰기" class="btn-register"> -->
			<!-- a 태그는 get 방식으로 처리 -->
			<button><a href="/myapp/board/register">글쓰기</a></button>
			</td>
		</tr>
	</table>
	<div>
	<c:if test="${pageMaker.prev}">
	<a href="/myapp/board/list?pageNum=${pageMaker.startPage-1}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">이전</a>
	</c:if>
		
	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	 <a href="/myapp/board/list?pageNum=${num}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${num}</a>
	</c:forEach>
	
	<c:if test="${pageMaker.next}">
	<a href="/myapp/board/list?pageNum=${pageMaker.endPage+1}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">다음</a>
	</c:if>
	</div>
	<!-- 게시판 검색란 -->
	
	<form action="/myapp/board/list" method="get">
	<div class="search">
	<select name="type"><!-- 내가 검색창에서 선택한 옵션과 검색어를 남겨주기 위해서 아래와 같이 추가 (selected) -->
		<option value="T" <c:out value="${pageMaker.cri.type eq 'T'? 'selected':''}"/>>제목</option>
		<option value="C" <c:out value="${pageMaker.cri.type eq 'C'? 'selected':''}"/>>내용</option>
		<option value="W" <c:out value="${pageMaker.cri.type eq 'W'? 'selected':''}"/>>작성자</option>
		<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'? 'selected':''}"/>>제목 + 내용</option>
		<option value="CW" <c:out value="${pageMaker.cri.type eq 'CW'? 'selected':''}"/>>내용 + 작성자</option>
		<option value="TCW"<c:out value="${pageMaker.cri.type eq 'TCW'? 'selected':''}"/>>제목 + 내용 + 작성자</option>
		
	</select>
	
	<input type="text" name="keyword" placeholder="검색어를 입력하세요" value="${pageMaker.cri.keyword}">
	<input type="submit" value="검색">
	</div>
	</form>
	</div><!-- wrap -->
</body>
</html>