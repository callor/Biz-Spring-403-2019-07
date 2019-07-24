<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" 
	href="${rootPath}/resources/css/main.css?ver=20190724" >

<link rel="stylesheet" type="text/css" 
	href="${rootPath}/resources/css/list.css?ver=20190723" >

<link rel="stylesheet" type="text/css" 
	href="${rootPath}/resources/css/input.css?ver=2019072401" >

<link rel="stylesheet" type="text/css" 
	href="${rootPath}/resources/css/login.css?ver=20190724" >

<link rel="stylesheet" type="text/css" 
	href="${rootPath}/resources/css/button.css?ver=20190723" >
	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<style>
	section.main-section {
		display: flex;
	}
	
	article.body-box {
		flex:1 1 33%;
		overflow: auto;
	}
	
</style>
<script>
$(function(){
	
	$.ajax({
		url : '${rootPath}/iolist/list',
		method : 'GET'
	})
	.done(function(result){
		$("#iolist_view").html(result)
	})
	
})
</script>	
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>

<section class="main-section">
	
	<article id="comp" class="body-box">
		<div id="comp_list"></div>
	</article>
	
	<article id="iolist" class="body-box">
		<%@ include file="/WEB-INF/views/ajax_body/iolist/input.jspf" %>
		<div id="iolist_view"></div>
	</article>

	<article id="product" class="body-box">
		<div id="pro_list"></div>
	</article>

</section>
<%@ include file="/WEB-INF/views/include/include-modal.jspf" %>
</body>
</html>