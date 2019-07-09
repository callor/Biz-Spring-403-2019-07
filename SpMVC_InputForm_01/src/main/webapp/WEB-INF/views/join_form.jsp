<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
	}

	fieldset {
		width:70%;
		margin:10px auto;
		border-radius: 4px;
		box-sizing: border-box;
		-webkit-box-sizing: border-box;
		-mos-box-sizing: border-box;
	}
	
	legend {
		font-weight: bold;
		color:blue;
	}
	
	div.in-box {
		display: flex;
		margin : 3px;
	}
	div.in-box label {
		display: block;
		width:100px;
		text-align: right;
		margin: 5px 5px;
	}
	div.in-box input {
		width : 70%;
		border : 1px solid red;
		border-radius: 4px;
	}
	
	div.btn-box {
		display: flex;
		justify-content: center;
		align-items: center;
		padding: 5px;
	}
	
	div.btn-box button {
		background-color: green;
		color:white;
		display: inline-block;
		padding: 15px 32px;
		font-size : 16px;
		margin: 4px 2px;
		cursor : pointer;
		text-align: center;
		border : 0;
		border-radius: 8px;
		transition-duration : 0.5s;
		-webkit-transition-duration : 0.5s; /* safari */
	}
	
	div.btn-box button:hover {
		background-color: white;
		border : 2px solid #008CBA;
		color : black;
	}
	
	input:focus {
		background-color: lightblue;
	}
	
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<br/><br/>
	<form method="POST">
	
		<fieldset>
		<legend>회원가입</legend>	
			<div class="in-box">
				<label for="m_userid">회원아이디</label>
				<input type="text" name="m_userid" id="m_userid">
			</div>
			<div class="in-box">
				<label for="m_password">비밀번호</label>
				<input type="password" name="m_password" id="m_password">
			</div>
			<div class="in-box">
				<label for="m_name">회원이름</label>
				<input type="text" name="m_name" id="m_name">
			</div>
			<div class="in-box">
				<label for="m_tel">전화번호</label>
				<input type="text" name="m_tel" id="m_tel">
			</div>
			<div class="btn-box"><button>회원가입</button></div>
		</fieldset>
	</form>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>