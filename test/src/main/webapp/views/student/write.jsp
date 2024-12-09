<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function fn_sendMember() {
		if ($("#id").val() == '') {
			alert('아이디를 입력하세요');
			$("#id").focus();
			return;
		}
		let con = true;
		$.ajax({
			url:'idCheck.do',
			data : {id:$("#id").val()},
			async: false,
			success : function(res) {
				if (res == true) {
					alert('중복된 아이디입니다.');
					con = false;
				}
			}
		});
		if (con == false) return;
		if ($("#pwd").val() == '') {
			alert('비밀번호를 입력하세요');
			$("#pwd").focus();
			return;
		}
		if ($("#grade").val() == '') {
			alert('학년을 입력하세요');
			$("#grade").focus();
			return;
		}
		if ($("#name").val() == '') {
			alert('이름을 입력하세요');
			$("#name").focus();
			return;
		}
		$("#frmMember").submit();
	}
	$(function(){
		$("#idCheck").click(function(){
			if ($("#id").val() == '') {
				alert('아이디를 입력하세요');
				$("#id").focus();
			} else {
				$.ajax({
					url:'idCheck.do',
					data : {id:$("#id").val()},
					success : function(res) {
						if (res == true) {
							alert('중복된 아이디입니다.');
						} else {
							alert('사용가능한 아이디입니다.');
						}
					}
				});
			}
		});
		$("#grade").keypress(function(event) {
			if(event.key >= 1 && event.key <= 6) {
			    return true;
			} else {
				alert('1~6사이의 숫자만 입력하세요');
				//$(this).val('');
			}
		})
	});
</script>
</head>
<body>
<form name="frmMember" id="frmMember" method="post" action='regist.do' enctype="multipart/form-data">
	<table>
		<tr>
			<th colspan="2">회원 가입창</th>
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" id="id">
				<input type="button" value="아이디 중복체크" id="idCheck">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd" id="pwd"></td>
		</tr>
		<tr>
			<td>학년</td>
			<td><input type="number" name="grade" id="grade"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td>주민번호</td>
			<td><input type="text" name="jumin"></td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				<input type="checkbox" name="hobbyName" value="영화">영화
				<input type="checkbox" name="hobbyName" value="독서">독서
				<input type="checkbox" name="hobbyName" value="게임">게임
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<input type="file" name="filename">
			</td>
		</tr>
	</table>
	<input type="button" value="가입하기" onclick="fn_sendMember()">
	<input type="reset" value="다시 입력">
</form>
</body>
</html>