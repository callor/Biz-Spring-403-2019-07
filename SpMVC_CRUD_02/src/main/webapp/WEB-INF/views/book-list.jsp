<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core"  
	prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		border:1px solid blue;
		width:100%;
	}
</style>
</head>
<body>
<h3>도서정보 리스트</h3>
<table border="1">
	<tr>
		<th>SEQ</th>
		<th>도서명</th>
		<th>출판사</th>
		<th>저자</th>
		<th>가격</th>
	<tr>
	<c:forEach items="${BOOKS}" var="bookVO" >
		<tr>
			<td>${bookVO.b_seq}</td>
			<td>${bookVO.b_title}</td>
			<td>${bookVO.b_comp}</td>
			<td>${bookVO.b_auth}</td>
			<td>${bookVO.b_price}</td>
		<tr>
	</c:forEach>
</table>
</body>
</html>