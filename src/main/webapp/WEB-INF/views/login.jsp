<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>

<body>
<h1>Login</h1>
 <form action="loginProc" method="post">
        <label for="email">이메일:</label>
        <input type="text" id="email" name="m_email" required>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="m_password" required>

        <input type="submit" value="로그인">
    </form>

</body>
<script type="text/javascript">
let msg = "${msg}";
if(msg != ""){
	alert(msg);
}	
</script>
</html>