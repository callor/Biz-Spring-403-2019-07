<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  rootPath = pageContext.request.contextPath  -->  
<%
	// String rootPath = request.getRequestURL().toString();
%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/book-main.css">
	
<link rel="stylesheet" type="text/css"
	href="${rootPath}/css/book-main.css">

</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>

<c:choose>
	<c:when test="${BODY == 'LOGIN'}">
		<%@ include file="/WEB-INF/views/body/book-login.jspf" %>
	</c:when>
	<c:when test="${BODY == 'JOIN'}">
		<%@ include file="/WEB-INF/views/body/book-join.jspf" %>
	</c:when>
	<c:when test="${BODY == 'BOOK-LIST'}">
		<%@ include file="/WEB-INF/views/body/book-list.jspf" %>
	</c:when>


	<c:otherwise>
		<%@ include file="/WEB-INF/views/body/book-list.jspf" %>
	</c:otherwise>
</c:choose>

</body>
</html>



