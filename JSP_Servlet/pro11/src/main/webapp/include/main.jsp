<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String pageName = "include/header.jsp";

String name = "홍길동";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	let name = '<%out.print(name);%>';
	console.log(name);'
</script>
</head>
<body>
	<%="<h1>안녕하세요</h1>"%>
	<!-- 비밀번호:1234 -->
	<%
	// 비밀번호:1234
	%>
	<%
	//@ include file="/include/header.jsp"
	%>
	<!-- 액션 태그 -->
	<jsp:include page="<%=pageName%>">
		<jsp:param value="lee" name="id" />
	</jsp:include>
	<div>메인</div>
</body>
</html>