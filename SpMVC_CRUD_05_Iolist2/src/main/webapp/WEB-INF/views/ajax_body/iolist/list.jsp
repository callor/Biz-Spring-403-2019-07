<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="list">
	<tr>
		<th>SQ</th>
		<th>거래일</th>
		<th>거래처</th>
		<th>상품</th>
		<th>단가</th>
		<th>수량</th>
		<th>매입합계</th>
		<th>매출합계</th>
	</tr>
	<c:choose>
		<c:when test="${empty IOLIST}">
			<tr><td colspan="7">데이터가 없습니다</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${IOLIST}" var="ioVO" varStatus="s">
				<tr>
					<td>${s.count}</td>
					<td>${ioVO.io_date}</td>
					<td>(${ioVO.io_ccode}) ${ioVO.io_cname}</td>
					<td>(${ioVO.io_pcode}) ${ioVO.io_pname}</td>
					<td>${ioVO.io_price}</td>
					<td>${ioVO.io_qty}</td>
					<td>${ioVO.io_itotal}</td>
					<td>${ioVO.io_ototal}</td>
				</tr>
			</c:forEach>					
		</c:otherwise>
	</c:choose>
</table>