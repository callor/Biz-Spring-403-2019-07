<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<script>
$(function(){
	
	$(".p_row").click(function() {
		let p_code = $(this).attr('data-seq')
		let p_name = $(this).children().eq(1).text()
		
		$("#io_pcode").val(p_code)
		$("#p_name").text(p_name)
		
	})
	
})

</script>
<table class="list">
	<tr>
		<th>상품코드</th>
		<th>상품명</th>
		<th>매입가격</th>
		<th>매출가격</th>
	</tr>
	<c:choose>
		<c:when test="${empty PRO_LIST}" >
			<tr>
				<td colspan="4">
				데이터가 없습니다
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${PRO_LIST}" var = "pVO" varStatus="s">
				<tr class="p_row" data-seq = "${pVO.p_code}" >
					<td>${pVO.p_code}</td>
					<td>${pVO.p_name}</td>
					<td>${pVO.p_iprice}</td>
					<td>${pVO.p_oprice}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>