<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
<script>
	function fn_sendMember() {
		var frmMember = document.frmMember;
		var id = frmMember.id.value;
		var pwd = frmMember.pwd.value;
		var name = frmMember.name.value;
		var email = frmMember.email.value;
		
		//if (id.length == 0 || id == '') {
		if (id.trim() == '') {
			alert('아이디는 필수입니다.');
			//id.focus();
			document.querySelector("input[name='id']").focus();
			return;
		}
		if (pwd.length == 0 || pwd == '') {
			alert('비밀번호는 필수입니다.');
			return;
		} 
		if (name.length == 0 || name == '') {
			alert('이름은 필수입니다.');
			return;
		} 
		if (email.length == 0 || email == '') {
			alert('이메일은 필수입니다.');
			return;
		}
		
		frmMember.method='post';
		frmMember.action='regist.do';
		frmMember.submit();
		
	}
</script>
</head>
<body>
<form name="frmMember">
	<table>
		<tr>
			<th colspan="2">회원 가입창</th>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"></td>
		</tr>
	</table>
	<input type="button" value="가입하기" onclick="fn_sendMember()">
	<input type="reset" value="다시 입력">
</form>
</body>
</html>