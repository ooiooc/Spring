$(document).ready(function(){
	
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$"); //정규식(해당 종류의 파일은 업로드 할 수 없도록 처리)
	var maxSize = 5242880; //파일 사이즈(5MB) 1204(MB) * 1024(MB) * 5 
	
	
	
	//정규식
	function checkExtension(fileName, fileSize){
		
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과")
			return false;
		}
		
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	
	
	//=================== 이미지 업로드 =============================
		
		function showUploadFile(uploadResultArr){
				
				var str = "";
			//data는 배열 for문과 같은 반복문을 이용하여 0~배열 끝까지 화면에 출력(each)
			$(uploadResultArr).each(function(i, obj){
				var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid +"_"+ obj.fileName);
				if(!obj.image){	
				//이미지파일이 아니면(image:false)
					str+= "<li><a href='/myapp/download?fileName="+fileCallPath+"'>" + "<img src='resources/Image/attach.png'>" + obj.fileName + "</a></li>";
					
				}else{
				//이미지파일이면(image:true)
					//var filecallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid +"_"+ obj.fileName);
					str+= "<li><img src='/myapp/display?fileName=" + fileCallPath +"'>"+ "<span data-file='"+ fileCallPath +"' data-type='image'><img src='resources/Image/x-icon.jpg'><span>" +"</li>";	
				
				}
					
			})
				$(".uploadResult ul").append(str);	
		}
		
	//=======================================================
		
	
	
	
	$(".fileDrop").on("dragenter dragover", function(e){
		e.preventDefault();
		//alert("drag");
	
	})
	
	$(".fileDrop").on("drop", function(e){ // start drop
	
		e.preventDefault();
		var files = e.originalEvent.dataTransfer.files;
	
		//console.log(files);
		
		var formData = new FormData(); //uploadAjax.jsp에 form 태그가 없다. 대체할 무언가가 필요한데, Formdata()
		console.log(formData);
		for(var i=0; i<files.length; i++){
			
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			
			formData.append("file",files[i]);
		}
		

		$.ajax({
			url:"/myapp/uploadAjax",
			data: formData,
			dataType: "json",
			// processData와 contentType은 파일 업로드 시 false가 되어야 한다
			processData: false,
			contentType: false,
			type: "POST",
			success: function(data){
				console.log(data);
				showUploadFile(data);
			}
		})
	
	}) //end of drop
	
	
	// x버튼 클릭 이벤트 시작
	$(".uploadResult").on("click","span",function(e){
		//alert("x 클릭")
		var fileName = $(this).data("file") // 파일을 저장하는 변수 - 데이터 선택자를 이용하여 값을 가져오기
		var type = $(this).data("type") // 이미지 파일여부 저장하는 변수
		alert(fileName)
		alert(type)
	
		//파일 종류가 이미지일 때 삭제하도록 1.파일이름 / 2. 이미지 파일 여부 값
		$.ajax({
			url:"/myapp/deleteFile",
			data: {fileName: fileName, type:type}, // 어떤 파일을 삭제해야하는지(파일명)/이미지 파일 여부(이미지 파일일 때 삭제되어야 한다)
			dataType: "text",
			type: "POST",
			success: function(data){
				console.log(data);
			}
		}) 
	})// x 클릭 이벤트 끝
})


