<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/www/css/w3.css" >
<script type="text/javascript"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<div class="w3-col m3">
		<p></p>
	</div>
	<div class="w3-col m6 w3-center">
		<h2 class="w3-col w3-padding w3-blue w3-margin-bottom">파일 업로드 게시판
			글쓰기</h2>

		<div class="w3-col w3-padding w3-margin-bottom">
		
			<form id="frm"  method="POST" action="/www/board/gallery.van" enctype="multipart/form-data"
			class="w3-col w3-card" >
				<input type="hidden" id="id" name="gid" value="${SID}">
				<div class="w3-row">
					<h4 class="w3-col m2 w3-right-align">Title :</h4>
					<div class="w3-col m10 w3-padding">
						<input class="w3-input w3-border" type="text" id="title"
							name="title" placeholder="# 제목을 입력하세요!">
					</div>
				</div>
				<div class="w3-row">
					<h4 class="w3-col m2 w3-right-align">Content :</h4>
					<div class="w3-col m10 w3-padding">
						<textarea class="w3-input w3-border" id="body" name="body"
							placeholder="글 내용 입력" cols="50" rows="10" style="resize: none"></textarea>
					</div>
				</div>
				<li>
					<div class="w3-col">
						<label for="prof">프로필사진</label>
						
						<div class="w3-col w3-padding prof">
							<input type="file" name="sFile" id="prof" class="w3-file profIn"
								style="height: 50px;">
						</div>
						<div id="" class="w3-padding w3-center">
							<img src="/www/img/profile/noimage.jpg" alt="noimage"
								class="pic1" id="profImg">
						</div>
					</div>
				</li>
				<div class="inputcl w3-margin-bottom">
					<input class="subcl" type="submit" id="join" value="Sign Up">
					<button id="returnBtn">Back</button>
				</div>

			</form>

		</div>
	</div>

</body>
</html>