<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 상세</h1>
아이디 : ${vo.id }<br>
이름 : ${vo.name }<br>
<c:if test="${vo.real_filename != null }">
<a href="/test/download.do?real=${vo.real_filename }&org=${URLEncoder.encode(vo.org_filename,"UTF-8") }"><img src="/test/upload/${vo.real_filename }" width=200></a>
</c:if>
</body>
</html>