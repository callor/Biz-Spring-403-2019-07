<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<h3>회원가입을 환영합니다</h3>
	<h5>아이디 : ${userid}</h5>
	<h5>비밀번호 : ${password}</h5>
	<h5>이름 : ${name}</h5>
	<h5>전화번호 : ${tel}</h5>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>