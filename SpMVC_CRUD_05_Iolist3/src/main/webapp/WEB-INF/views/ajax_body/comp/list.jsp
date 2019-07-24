<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<script>
$(function(){
	$(".c_row").click(function(){
		let c_code = $(this).children().eq(0).text();
		let c_name = $(this).children().eq(1).text();
		let c_ceo = $(this).children().eq(2).text();
		
		$("#io_ccode").val(c_code)
		$("#comp_name").val(c_name + "/" + c_ceo)
	})
})
</script>

<table class="list">
	<tr>
		<th>CODE</th>
		<th>거래명</th>
		<th>대표</th>
		<th>전화번호</th>
		<th>주소</th>
	</tr>
	<c:choose>
		<c:when test="${empty COMP_LIST}">
			<tr>
			<td colspan="5">데이터가 없습니다</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${COMP_LIST}" var="cVO">
				<tr class="c_row">
					<td>${cVO.c_code}</td>
					<td>${cVO.c_name}</td>
					<td>${cVO.c_ceo}</td>
					<td>${cVO.c_tel}</td>
					<td>${cVO.c_addr}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>