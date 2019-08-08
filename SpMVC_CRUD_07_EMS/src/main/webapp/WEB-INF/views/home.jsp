<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMS</title>

<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/main.css?ver=20190719">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/list.css?ver=2019072501">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/button.css?ver=20190725">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/input.css?ver=2019080701">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/view.css?ver=20190726">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/login.css?ver=20190719">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/album.css?ver=20190726">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<section>
		<c:choose>

			<c:when test="${BODY == 'JOIN' }">
			</c:when>		

			<c:otherwise>
				<h3>Email Management System 1.0</h3>
			</c:otherwise>

		</c:choose>	
	</section>
	
</body>
</html>