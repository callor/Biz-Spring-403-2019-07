<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
	content="width=device-width, initial-scale=1">
<title>내이버는 내친구</title>
<style>
	body {
		display: flex;
		margin:0;
		flex-flow: column wrap;
	}
	
	header {
		background-color: #ccc;
		text-align: center;
	}

	nav {
		display: flex;
		flex-flow : row wrap;
		background-color: green;
		color:white;
	}
	
	nav a {
		display: inline-block;
		text-decoration: none;
		padding:10px;
		margin : 0 5px;
		color:inherit;
	}
	
	nav a:hover {
		background-clip: #ccc;
		color:blue;
		font-weight: bold;
	}
	
	input, select {
		display:inline-block;
		height: 30px;
		margin:0 5px;
		padding:5px;
		
		border-radius: 5px;
		border:1px solid green;
	
	}
	
	section#main-container {
		flex:1 0 auto;
		
		display: flex;
		flex-flow: wrap;
		height: 100%;
		justify-content: center;
	
	}
	
	div.view-item {
		border:1px solid blue;
		background-color: #ccc;
		border-radius: 5px;
		
		margin:5px;
		padding: 5px;
	}
	
	div.view-item img {
		float:left;
		margin:3px;
	}
	

</style>

</head>
<body>
	<header>
		<h3>네이버 검색</h3>
	</header>
	<nav>
		<a href="#">Home</a>
		<form action="${rootPath}/naver/search" method="POST">
			<select name="category">
				<option value="BOOK">도서정보</option>
				<option value="MOVIE">영화정보</option>
				<option value="NEWS">뉴스</option>
			</select>		
			<input 
				type="text" 
				name="search_text" 
				id="search" 
				placeholder="검색어를 입력한 후 Enter...">
		</form>
	</nav>
	
	<section id="main-container">
		<c:forEach items="${NAVERS}" var="nVO">
			<div class="view-item">
				<h4>
					<a href="${nVO.link}" target=_new>${nVO.title}</a>
				</h4>
				<img src="${nVO.image}">
				<p>${nVO.description}</p>			
			</div>		
		</c:forEach>
	</section>
</body>
</html>