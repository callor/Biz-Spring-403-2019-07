<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/input.css?ver=20190723">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/resources/css/button.css?ver=20190723">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
 span#check_id {
 	color:red;
 	font-weight: bold;
 	display: hidden;
 }

</style>
<script>
$(function(){
	
	// 입력박스에서 focus가 벗어났을때
	$("#m_userid").blur(function(){
		let m_userid = $(this).val()
		
		$.ajax({
			url : '${rootPath}/member/check_id?m_userid=' + m_userid,
			method:'GET'
		})
		.done(function(result){
			if(result == m_userid) {
				let msg = "이미 가입된 ID 입니다"
				$("#check_id").text(msg)
				$("#check_id").css("display","block")
				
				// alert("이미 가입된 ID 입니다 \n " 
				// 	+ "다른 ID를 입력해 주세요 ")
				
				$("#m_userid").focus()
				$("#m_userid").select()
				return false
			}
		})
	})
	
	
	$("#btn-join").click(function() {
		let pass = $("#m_password").val()
		let re_pass = $("#m_re_password").val()
		
		if(pass == "") {
			alert("비밀번호를 입력하세요")
			$("#m_password").focus()
			return false
		}

		if(re_pass == "") {
			alert("비밀번호 확인을 입력하세요")
			$("#m_re_password").focus()
			return false
		}
		
		if(pass != re_pass) {
			alert("비밀번호와 비밀번호 확인문자가 다릅니다.")
			$("#m_password").val("")
			$("#m_re_password").val("")
			$("#m_password").focus()
			return false
		}
		
	})
	
})

</script>
		
<form method="POST">
	<fieldset>
		<legend>회원가입</legend>
		<div class="in-box">
			<label for="m_userid">회원아이디</label> 
			<input type="text"
				name="m_userid" id="m_userid"><br/>
			<span id="check_id"></span>
		</div>
		<div class="in-box">
			<label for="m_password">비밀번호</label> 
			<input type="password"
				name="m_password" id="m_password">
		</div>
		<div class="in-box">
			<label for="m_password">비밀번호확인</label> 
			<input type="password"
				name="m_password" id="m_re_password">
		</div>
		<div class="in-box">
			<label for="m_name">회원이름</label> 
			<input type="text" 
				name="m_name" id="m_name">
		</div>
		<div class="in-box">
			<label for="m_email">이메일</label> 
			<input type="text" 
				name="m_email" id="m_email">
		</div>

		<div class="in-box">
			<label for="m_tel">전화번호</label> 
			<input type="text" 
				name="m_tel" id="m_tel">
		</div>
		<div class="btn-box center">
			<button id="btn-join" 
					type="button" 
					class="bz-btn save">회원가입</button>
		</div>
	</fieldset>
</form>
