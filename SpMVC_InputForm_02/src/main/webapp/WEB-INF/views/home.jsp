<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 
		uri="http://java.sun.com/jsp/jstl/core" 
		prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
	<%@ include 
		file="/WEB-INF/views/include/include-head.jspf" %>
</head>
<body>
<%@ include 
	file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include 
	file="/WEB-INF/views/include/include-nav.jspf" %>

	<section>
	<!-- when : BODY에 BOOK_INSERT 문자열이 담겨 있으면 -->
	<!-- othwise : 조건에 맞는 항목이 없으면 -->
	<c:choose>
		<c:when test="${BODY ==  'BOOK_INSERT'}">
			<%@ include 
				file="/WEB-INF/views/body/form_book.jspf" %>
		</c:when>
		<c:when test="${BODY == 'BOOK_VIEW' }">
			<h4>도서명 : ${Book.b_title }</h4>
			<h4>출판사 : ${Book.b_comp}</h4>
			<h4>저자 : ${Book.b_auth}</h4>
			<h4>가격 : ${Book.b_price}</h4>
		</c:when>
		<c:otherwise>
			<h3>나의 홈페이지</h3>	
		</c:otherwise>
	</c:choose>

	<c:if test="${BODY == 'BOOK_INSERT'}">
	</c:if>

	</section>
	
<%@ include 
	file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>