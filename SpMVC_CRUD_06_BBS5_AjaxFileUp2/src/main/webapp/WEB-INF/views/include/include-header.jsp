<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<c:set var="rootPath" value="${pageContext.request.contextPath}" /> 
<style>
	header h2 a {
		color:white;
		text-decoration: none;
	}
</style>
<header>
	<h2><a href="${rootPath}/">심플 게시판</a></h2>
</header>
<style>
	.dropbtn {
		display: block;
		color:white;
		text-align: left;
		padding:14px 16px;
		text-decoration: none;
	}

	li.dropdown {
		display: block;
	}
	
	div.dropdown-content {
		display: none;
		position: absolute;
		background-color: cyan;
		min-width: 160px;
		box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		z-index: 5;
	}
	
	li.dropdown:hover div.dropdown-content {
		display: block;
	}
	
	li.dropdown-content a {
		border-top: 1px solid white;
		background-color: green;
		color:yellow;
	}
	
	li.dropdown-content a:hover {
		background-color: #ccc;
		color:blue;
	}
	
	li.member {
		margin-left:auto;
	}

</style>
<nav>
	<ul class="main-menu">
		<c:if test="${not empty MENUS}">
			<c:forEach items="${MENUS}" var="MENU">
				<c:choose>
					<c:when test="${empty MENU.menu_subs}">
						<li><a href="${rootPath}/${MENU.menu_href}">${MENU.menu_title}</a></li>	
					</c:when>
					<c:otherwise>
						<li class="dropdown">
							<a href="javascript:void(0)" 
								class="dropbtn">${MENU.menu_title}
							</a>
							<div class="dropdown-content">
								<c:forEach items="${MENU.menu_subs}" var="SUB">
									<a href="${rootPath}/${SUB.menu_href}">${SUB.menu_title}</a>
								</c:forEach>							
							</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>		
		</c:if>
		<c:if test="${empty LOGIN}">
			<li class="member"><a href="${rootPath}/member/login">로그인</a></li>
			<li><a href="${rootPath}/member/join">회원가입</a></li>
		</c:if>
		<c:if test="${!empty LOGIN}">
			<li class="member"><a href="${rootPath}/member/logout">로그아웃</a></li>
			<li><a href="${rootPath}/member/logout">(${LOGIN.m_email})</a></li>
		</c:if>
		
	</ul>
</nav>