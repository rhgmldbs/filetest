<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/www/css/w3.css">
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){ 
		$('#gallerybtn').click(function() {
			$(location).attr('href','/www/board/uploading.van');
		});
		
		
		
		$('.cul').click(function() {
			var gno=$(this).attr('data-id')
			$(location).attr('href','/www/board/gallerycontent.van?gno='+gno);
			
		
		});
	});
</script>
</head>
<body>


	<div class="w3-container w3-teal">
		<h1>Summer Holiday</h1>
	</div>

	<div class="w3-row-padding w3-margin-top">
	
		<c:forEach var="data" items="${LIST}" >
			<div class="w3-third">
				<div class="w3-card">
					<img src="/www/upload/${data.saveName}" style="width: 100%" class="cul" data-id="${data.gno}">
					<div class="w3-third" id="ofile"><%-- ${data.oriName} --%></div>
				</div>
				<div class="w3-container">
					<h4>${data.title}</h4>
				</div>
				<button id="like">좋아요</button>${vo.cnt1} <%-- <button id="unlike">싫어요</button>${vo.cnt2} --%>
				 
			</div>
		</c:forEach>
	</div>




	<button id="gallerybtn">갤러리 글쓰기</button>
	
</body>

</html>