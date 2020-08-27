/**
 * 
 */
//$() 안에 들어가는 것 = 선택자
//attr : 속성값 변경
//


$(document).ready(function(){
	var formObj = $("form[role='form']"); // 
	
	console.log(formObj);
	
	//수정 버튼 클릭했을 때
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/myapp/board/modify");
		//attr안에 값이 하나면 getter, 값이 두 개  들어가면 setter
		//action=myapp/board/mod =get방식
		formObj.attr("method", "get");
		formObj.submit();
	});
	
	//삭제 버튼 클릭했을 때
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/myapp/board/remove"); 
		//action=myapp/board/remove =post방식
		formObj.attr("method", "post");
		formObj.submit();
	});
	
	//목록 버튼 클릭했을 때
	$(".btn-primary").on("click", function(){
		formObj.attr("action", "/myapp/board/list");
		//action=myapp/board/list = 
		formObj.attr("method", "get");
		formObj.submit();
	});
	
});

