<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
		prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>

</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<c:choose>
	<c:when test="${TEMP == 'AA' }">
	</c:when>
	<c:otherwise>
		<p>나의 홈페이지</p>
	</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>