<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="rangking.RangkingVO"%>
<%@ page import="rangking.RangkingDAO"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-color: #000;
	color: #fff;
}

.podium-container {
	position: relative;
	width: 600px;
	height: 400px;
	margin: 50px auto;
	background-size: contain;
}

.header_img {
	width: 241.47px;
	height: 85px;
}

.podium-text {
	position: absolute;
	color: #fff;
	font-size: 16px;
	text-align: center;
}

.first {
	top: 50px;
	left: 50%;
	transform: translateX(-50%);
}

.second {
	top: 100px;
	left: 20%;
	transform: translateX(-50%);
}

.third {
	top: 100px;
	left: 80%;
	transform: translateX(-50%);
}
</style>
</head>
<body>
	<!-- 1등 -->
	<div class="podium-text first">
		<c:out value="${list[0].userName}" />
		님<br>
		<c:out value="${list[0].winCount}" />
		승
	</div>
	<!-- 2등 -->
	<div class="podium-text second">
		<c:out value="${list[1].userName}" />
		님<br>
		<c:out value="${list[1].winCount}" />
		승
	</div>
	<!-- 3등 -->
	<div class="podium-text third">
		<c:out value="${list[2].userName}" />
		님<br>
		<c:out value="${list[2].winCount}" />
		승
	</div>
	
	<div class="podium-container">
		<img src="img/rangking_header_img.png" alt="Podium" class="header_img">
		<img src="img/rangking_podium.png" alt="Podium">
		<%
		RangkingVO rangkingVO = new RangkingVO();
		RangkingDAO dao = new RangkingDAO();
		List<RangkingVO> list = dao.listMembers();
		%>
		<%
		for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getUserName() + "님"%></td>
			<td><%=list.get(i).getWinCount() + "승"%></td>
		</tr>
		<%
		}
		%>
	</div>
</body>
</html>