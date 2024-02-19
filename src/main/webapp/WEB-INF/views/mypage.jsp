<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MyPage</title>
</head>

<body>
    <h1>MyPage</h1>

<c:if test="${loggedInMember ne null}">
    <p>이름 : ${loggedInMember.m_name}</p>
    <p>이메일 : ${loggedInMember.m_email}</p>
    <p>전화번호 : ${loggedInMember.m_phoneNumber}</p>
    <p>주소 : ${loggedInMember.m_address}</p>
    <p>나이 : ${loggedInMember.m_age}</p>
    <p>예약한 클래스 : ${loggedInMember.classCode}</p>
    <!-- 추가로 출력할 회원 정보가 있다면 여기에 추가 -->
    
    <form action="logout" method="get">
        <input type="submit" value="로그아웃">
    </form>
    <button onclick="location.href='./setting'">회원정보수정</button>
   	<button onclick="location.href='./'">홈페이지 돌아가기</button>
</c:if>
   
</body>
<script type="text/javascript">
let msg = "${msg}";
if(msg != ""){
	alert(msg);
}	
</script>

<script type="text/javascript">
	function name() {
		if (name = hompage)
	}
</script>
</html>