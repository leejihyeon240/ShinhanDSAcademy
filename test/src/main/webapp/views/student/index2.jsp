<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
총 ${map.count }명 <c:if test="${!empty loginInfo }">${loginInfo.name }님 안녕하세요</c:if>
<table border=1 width=800 align=center>
	<tr align=center bgcolor="#FFFF66">
		<td>학생번호</td>
		<td>이름</td>
		<td>아이디</td>
		<td>학년</td>
		<td>교수</td>
	</tr>
<c:forEach var="vo" items="${map.list }">
	<tr>
		<td><a href="view.do?studno=${vo.studno}">${vo.studno }</a></td>
		<td>${vo.name }</td>
		<td>${vo.id }</td>
		<td>${vo.grade }</td>
		<td>${vo.profname }</td>
	</tr>
</c:forEach>
</table>