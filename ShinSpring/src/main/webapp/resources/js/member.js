/**
 * 
 */

$(document).ready(function(){
	
	//id가 userid인 것을 선택하기 (id 선택자)
	//이벤트 : blur, keyup 등
	//blur : 포커스가 없어졌을때 발생하는 이벤트
	//keyup : 선택한 요소에서 키보드를 눌렀다가 떼었을 때 이벤트가 발생합니다. / $("선택자").keyup();
	
	$("#userid").on("blur", function(){
		//alert("^__________^");
		
		//아이디 유효성 검사 (영문+숫자 총 길이는 4~12자 이내)
		let idreg = /^[a-zA-Z0-9]{4,12}$/; //ID 유효성 검사를 위한 정규식
		let idVal = $("#userid").val();    // 사용자가 ID에 입력한 값
		
		if(idreg.test(idVal)){ //입력한 ID 값과 정규식이 맞으면
			//alert("유효성 검사 통과");
			$("#idmsg").html("멋진 아이디네요!");
			
		}else{ //틀리면 
			//alert("아이디를 재 입력해주세요");
			$("#idmsg").html("영문+숫자 총 길이는 4~12자 이내로 입력해주세요");
		}	
	})//id blur이벤트 끝
	
	//비밀번호 blur 이벤트 start	
	//비밀번호 유효성 검사(대문자 + 소문자 + 숫자 + 특수문자 + 모두 포함하며, 총 길이는 8자 이상)
	//=.*? [] 범위 중 하나는 꼭 들어가야 한다는 의미
	//a* : a가 0개 또는 여러개
	//a? : a가 0개 또는 한 개
	//. : 아무 문자
	$("#userpw").on("blur", function(){	
		
		let pwreg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		let pwVal=$("#userpw").val();
				
		if(pwreg.test(pwVal)){ //입력한 pw값과 정규식이 맞으면,
			//alert("유효성 검사 통과");
			$("#pwmsg").html("비밀번호 완료");
			
		}else{ //틀리면 
			//alert("아이디를 재 입력해주세요"); 
			$("#pwmsg").html("비밀번호는 대소문자, 숫자, 특수문자를 모두 포함하며 총 길이는 8자 이상이어야 합니다");
		}
		
	})//end of 비밀번호 유효성 검사
	
	//비밀번호 일치 
	$("#repw").on("keyup",function(){
		
		if($("#userpw").val() == $("#repw").val()){
			$("#repwmsg").html("<p style: color='blue'>비밀번호 일치");
		}else{
			$("#repwmsg").html("<p style: color='blue'>비밀번호가 일치하지 않습니다");
		}
	})
	
	//아이디 중복체크(ajax활용 : 1 = 중복 / 0 != 중복)
	//사용자가 입력한 id값을 data로 처리하고 data값을 매개변수로 받아서 처리하는 controller를
	//생성한 후 id값으로 select된 결과를 조회하여 성공적으로 ajax에게 값을 넘겨받아서 처리
	
	$("#checkId").on("click",function(){
		var userid=$("#userid").val();
		//id="id_reg" name=
		/* 
		$.ajax({
			url:"/myapp/member/checkId",
			type: "GET",
			dataType: "json",
			//contentType: "application/json; charset=UTF-8",
			data: $("#userid").val(),
			
			error: function(){
				alert("실패");
			},
			
			success: function(data){ //checkId에서 넘겨준 결과값
				
				console.log("1 = 중복o / 0 = 중복x : "+ data);		
				
				if(data == 1)
					$("#idmsg").html("이미 가입된 아이디입니다");
				else(data == 0)
					$("#idmsg").html("사용가능합니다");
				}
		})*/
		
		$.getJSON("/myapp/member/checkId/" + userid, function(data){
			console.log("data="+data);
			if(data == 1){
				$("#idmsg").html("이미 가입된 아이디입니다");
			}
			else{
				$("#idmsg").html("사용가능합니다");
			}
		})
	
	})//end 중복체크 */
	
}) //end of document