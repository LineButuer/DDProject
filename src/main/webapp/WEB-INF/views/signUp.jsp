<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script>
	$(function() {
		let msg = "${msg}";
		if(msg != ""){
			alert(msg);
		}
	});
</script>
</head>


<body>
	<h1>Sign Up</h1>
	<form action="signUpProc" method="post" enctype="multipart/form-data">
		<input type="text" value="이름" name="m_name"> 
		<input type="text" value="전화번호" name="m_phoneNumber">
		<input type="text" value="이메일" name="m_email">
		<input type="text" value="비밀번호" name="m_password">
		<input type="text" value="주소" name="m_address">
		<input type="text" value="나이" name="m_age">
		<input type="text" value="프로필사진">
		
		<label for="classCode">클래스:</label>
        <select name="classCode">
            <option value="Classcode1">Classcode1</option>
            <option value="Classcode2">Classcode2</option>
            <option value="Classcode3">Classcode3</option>
        </select>
        
		<input type="submit" value="Test">
	</form>
</body>
</html>