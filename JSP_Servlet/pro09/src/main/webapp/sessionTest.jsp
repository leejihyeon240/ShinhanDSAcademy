<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Map<String, Object> member = (Map<String, Object>) session.getAttribute("member");
	out.print(member.get("name") + "<bt>");
	out.print(member.get("age") + "<br>");
	%>
</body>
</html>