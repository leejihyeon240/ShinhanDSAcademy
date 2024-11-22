<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 테스트</h1>
	자바 :
	<%=request.getAttribute("name")%>
	<br> 자바 :
	<%
	String name = (String) request.getAttribute("name");
	out.print(name);
	%>
	<!-- request에서 name이라는 이름의 속성값 -->
	<br> EL(request) : ${name} / ${requestScope.name }
	<!-- session에서 id라는 이름의 속성값 -->
	<br> EL(session) : ${id} / ${sessionScope.id }
	<!-- member 속성(MemberVO)의 id => getId() -->
	MemberVO 객체의 id : ${member.id} / ${member.nickname }
	<!-- Map객체 속성이름이 map 안에 키 tel -->
	<br> Map 객체의 tel : ${map.tel }
	<!-- Map객체 안에 MemberVO 객체 안에 id -->
	<br> Map안에 MemberVO안에 id : ${map.vo.id }
	<br> 동등 비교 : ${map.vo.id == 'lee님' } / ${map.vo.id eq 'lee님' }
	<!-- 크거나 같다 : ge, 작거나 같다 : le -->
	<br> 크다 : ${3 gt 2 } / 작다 : ${2 lt 3 }
	<!-- 비어있으면(null이면 tru) -->
	<br> 비어있는지(null인지) : ${empty map }
	<!-- 값이 있으면(null이 아니면) true -->
	<br> 비어있지 않은지(null이 아닌지) : ${not empty map }
	<!-- 파라미터 중에 이름(name)이 search인 값(value) -->
	<br> 파라미터(param) : ${param.search }
</body>
</html>