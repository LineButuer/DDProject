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
		질문등록</button>
		
<div>
	<c:if test="${empty qList}">
				<div class="qboard-item">
					<span class="none-content">등록된 게시물이 없습니다.</span>
				</div>
	</c:if>
	<c:if test="${qList ne null}">
		<c:forEach var="qqq" items="${qList}">
			<div>
				<a href="detail?b_code=${qqq.b_code}">제목 : "${qqq.b_title}" </a>
			</div>
		</c:forEach>
	</c:if>
</div>

	<!-- 페이지 기능 -->
	<div class="paging-area">
		<div class="paging">${paging}</div>
	</div>
</body>
<script>
	$("#upbtn").click(function() {
		location.href = `./QBUpdate?b_code=${qqq.b_code}`;
	});
</script>
</html>