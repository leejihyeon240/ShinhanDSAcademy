<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 상세</h1>
	아이디 : ${vo.id }
	<br> 이름 : ${vo.name }
	<br>
	<c:if test="${vo.read_filename != null }">
		<img src="/test/upload/${vo.real_filename} " width="200">
	</c:if>
</body>
</html>