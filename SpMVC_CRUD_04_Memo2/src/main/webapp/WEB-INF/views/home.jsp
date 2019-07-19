<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 심플 메모장</title>

<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/main.css?ver=20190719">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/list.css?ver=20190719">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/button.css?ver=20190719">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/input.css?ver=20190719">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/view.css?ver=20190719">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/login.css?ver=20190719">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<p></p>
	<section>
		<c:choose>

			<c:when test="${BODY == 'MEMO' }">
				<%@ include file="/WEB-INF/views/body/memo_list.jspf" %>			
			</c:when>		
			<c:when test="${BODY == 'MEMO_WRITE' }">
				<%@ include file="/WEB-INF/views/body/memo_write.jspf" %>			
			</c:when>		
			<c:when test="${BODY == 'MEMO_VIEW' }">
				<%@ include file="/WEB-INF/views/body/memo_view.jspf" %>			
			</c:when>		

			<c:when test="${BODY == 'LOGIN' }">
				<%@ include file="/WEB-INF/views/body/login.jspf" %>			
			</c:when>		



		</c:choose>	
	</section>
	
</body>
</html>