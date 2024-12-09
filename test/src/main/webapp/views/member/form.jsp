<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입</h1>
<form method="post" action="/test/user/member/regist.do">
<input type="text" name="id"><br>
<input type="text" name="name"><br>
<input type="submit">
</form>
vo : ${memberVO }<br>
map : ${map }
</body>
</html>