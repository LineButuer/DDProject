<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시물 작성</title>
</head>
<body>
	
	
	<form action="qwriteProc" method="get" enctype="multipart/form-data">
	<h2>게시물 등록</h2>
	<input type="text" placeholder="제목" name="b_name"> 
	<input type="text" placeholder="작성자" name="b_writer">
	<input type="text" placeholder="내용" name="b_contents">
	<input type="text" placeholder="비밀번호" name="b_password">
	<input type="text" placeholder="댓글" name="b_comment">
	<button value ="submit">등록</button>
	</form>

</body>
</html>