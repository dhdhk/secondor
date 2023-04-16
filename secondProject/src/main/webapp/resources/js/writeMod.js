	


	var cnt=1;
	

	
	function modImgButton1(){
		$("#pr_img1").attr('style', ' ' );
		$("#mod_img1").attr('style','display:none;');
	}
	
	
	
	if('${proInf.pr_img1}'){
		cnt++;
	}
	if('${proInf.pr_img2}'){
		cnt++;
	}
	if('${proInf.pr_img3}'){
		cnt++;
	}
	function modImg1(){
		$("#d_file1").empty();
		$("#d_file1").append("<input type='file' name='pr_img1' accept='image/*' onchange='readURL1(this);' id='pr_img1'>");
	}
	function modImg2(){
		$("#d_file2").empty();
		$("#d_file2").append("<input type='file' name='pr_img1' accept='image/*' onchange='readURL2(this);' id='pr_img2'>" );
	}
	function modImg3(){
		$("#d_file3").empty();
		$("#d_file3").append("<input type='file' name='pr_img3' accept='image/*'>");
	}
	function fn_addFile(){
		if(cnt<4){$("#d_file").append("<br><input type='file' name='pr_img"+cnt+"' accept='image/*'>");
		cnt++;}
		if(cnt==4){$("#d_file").append("<br>사진은 최대 3장까지 등록할 수 있습니다.");
		cnt++;}
		if(cnt>5){}
		
	}
	function fn_rmFile(obj){
		$(obj).empty();
		cnt--;
	}
	function backToList(obj){
		obj.action = "${contextPath}/main.do";
		obj.submit();
	}
	
	function readURL1(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview1').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function readURL2(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview2').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function readURL3(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview3').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function onlyNumber(){
        if((event.keyCode<48)||(event.keyCode>57))
           event.returnValue=false;
	}
	function remove1(){
		var agent = navigator.userAgent.toLowerCase();
		//파일초기화
		if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		    $("#pr_img1").replaceWith($("#pr_img1").clone(true));
		}else{
		    $("#pr_img1").val("");
		    $('#preview1').attr('src','${contextPath }/resources/image/noImage.png');
		}
	}
	function remove2(){
		var agent = navigator.userAgent.toLowerCase();
		//파일초기화
		if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		    $("#pr_img2").replaceWith($("#pr_img2").clone(true));
		}else{
		    $("#pr_img2").val("");
		    $('#preview2').attr('src','${contextPath }/resources/image/noImage.png');
		}
	}
	function remove3(){
		var agent = navigator.userAgent.toLowerCase();
		//파일초기화
		if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		    $("#pr_img3").replaceWith($("#pr_img3").clone(true));
		}else{
		    $("#pr_img3").val("");
		    $('#preview3').attr('src','${contextPath }/resources/image/noImage.png');
		}
	}