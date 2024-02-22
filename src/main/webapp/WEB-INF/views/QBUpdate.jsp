<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<script>
 $(function () {
            let m = "${msg}"";
            if(m != "df"){
                alert(m);
            });
</script>
<body>
	<div class="content">
	<!-- sessionScope."세션에 저장된 이름" <-- 세션에 저장된 모든 정보에 접촉 가능 -->
		<c:if test="${sessionScope.login eq qboard.m_id}">
			<form action="QBUpdateProc" method="post"
				enctype="multipart/form-data">
				<h2 class="form-header">게시물 수정</h2>
				<input type="hidden" name="b_code" value="${qboard.b_code}">
				<input type="text" class="write-input" value="${qboard.b_title}"
					name="b_title" autofocus placeholder="제목" required> <input
					type="text" class="write-input" value="${qboard.b_contents}"
					name="b_contents" placeholder="내용" required> <input
					type="text" class="write-input" value="${qboard.b_password}"
					name="b_password" placeholder="비밀번호" required>
				<button value="submit">수정</button>
			</form>
		</c:if>
		<c:if test="${sessionScope.login ne qboard.m_id}">
			<p>게시물을 수정할 수 있는 권한이 없습니다.</p>
		</c:if>
	</div>
</body>
<script>
$("#backbtn").click(function () {
	location.href = `./detail?b_code=${qboard.b_code}`;
});</script>
</html>