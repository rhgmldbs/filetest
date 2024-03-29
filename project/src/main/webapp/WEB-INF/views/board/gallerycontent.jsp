<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/www/css/bootstrap.min.css">
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {

		/*  $('#update').click(function() {
		     $(location).attr('href', '');
		  });
		 */

		
	/* 	$('#delcon').click(function() {
			var no = $('#delcon').attr('data-no');
			$(location).attr('href', '/member/delcontent.psl?no=' + no);
		}); */
		$('#update').click(function() {
			$('.show').css('display', 'none');
			$('.hide').css('display', 'block');
		});

		$('#cancel').click(function() {
			$('.show').css('display', 'block');
			$('.hide').css('display', 'none');
		});

		 $('#delcon').click(function() {
				var no = $('#delcon').attr('data-no');
		     $(location).attr('href','/www/board/gallerydelete.van?gno='+no);
		
	});
	});	 
</script>
<style>
body {
	padding: 60px 10px;
	background-size: cover;
	background-image:
		url('https://www.shearwaterdental.com/dental-chair/uploads/2017/05/Shearwater-login-background-1150x719.jpg');
}

nav {
	border: 1px solid #9C9C9C;
}

.hide {
	display: none;
}
</style>

</head>
<body>

	<div class="container show" style="width: auto; margin-top: 100px;">
		<div class="row">
			<table class="table table-striped border"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">상세보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th class="border-right">글번호</th>
						<td>${vo.gno}</td>
					</tr>
					<tr>
						<th class="border-right">글제목</th>
						<td>${vo.title }</td>
					</tr>
					<tr>
						<th colspan="2">글내용</th>
					</tr>
					<tr>
						<td colspan="2" id="bdy" style="height: 350px;">${vo.body}</td>
					</tr>
					<tr>
						<td colspan="2" id="pic" style="height: 350px;"><img
							src="/www/upload/${vo.saveName}"></td>
					</tr>

				</tbody>
			</table>
			<%--  <c:if test="${vo.id == SID}" > --%>
			<button class="btn btn-info pull-right" type="button" id="update">수정</button>
			<button class="btn btn-danger pull-left" type="button" id="delcon" data-no="${vo.gno}">삭제</button>
			<%-- </c:if>  --%>
		</div>
	</div>
	<form action="/www/board/galleryconfig.van" class='hide' method="post" enctype="multipart/form-data">
		<input type="hidden" name="gno" value="${vo.gno}" />
		<div class="container hide" style="width: auto">
			<div class="row">
				<table class="table table-striped border"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="3"
								style="background-color: #eeeeee; text-align: center;">상세보기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th class="border-right">글번호</th>
							<td>${vo.gno}</td>
						</tr>
						<tr>
							<th class="border-right">글제목</th>
							<td><input class="form-control" type="text"
								value="${vo.title}" name="title" style="width: 98%" /></td>
						</tr>

						<tr>
							<th colspan="2">글내용</th>
						</tr>
						<tr>
							<td colspan="2" id="bdy" style="height: 350px;"><textarea
									class="form-control hide" rows="5" style="height: 350px;"
									name="body" maxlength="2048">${vo.body}</textarea></td>
						</tr>
						<tr>
							<td colspan="2"><input type="file" name="sFile" id="prof"
								class="w3-file profIn" style="height: 50px;">
								
											
						</tr>

					</tbody>
				</table>



				<input type="submit" class="1btn btn-info pull-right" value="수정완료" />
				<button type="button" class="btn btn-danger pull-left" id="cancel">취소</button>

			</div>
		</div>
	</form>



</body>

</html>