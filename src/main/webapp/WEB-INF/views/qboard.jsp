<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>

	<button class="wr-btn" onclick="location.href='./qwrite'">
				질문등록
			</button>
	<c:if test="${qList ne null}">
		<c:forEach var="qqq" items="${qList}">
	<p>제목 : "${qqq.b_name} " </p>
	<p>게시글 : "${qqq.b_contents}"</p>
		</c:forEach>
	
	</c:if>
	
		
	
		
	
</body>
</html>