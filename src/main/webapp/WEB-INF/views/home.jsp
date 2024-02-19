<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Test Home</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<script>
$(function() {
	let m = "${msg}";
	if (m != "") {
		alert(m);
	}
});

</script>
</head>
<h1> Home Page</h1>
<body>
<a href ="signUp">[회원가입 이동]</a>
<a href ="login">[로그인 이동]</a>
<a href ="mypage">[마이페이지]</a>
<a href ="qwrite">[질문게시판]</a>
</body>
</html>
