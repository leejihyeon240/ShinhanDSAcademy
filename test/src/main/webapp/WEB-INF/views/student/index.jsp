<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">학생 정보 출력</h1>
총 ${map.count }명
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
		<td>${vo.studno }</td>
		<td>${vo.name }</td>
		<td>${vo.id }</td>
		<td>${vo.grade }</td>
		<td>${vo.profname }</td>
	</tr>
</c:forEach>
</table>
<form method="get" action="index.do" style="width:800px;margin:0 auto;">
학년:
<select name="searchGrade">
	<option value="0">전체</option>
	<option value="1" <c:if test="${param.searchGrade == '1' }">selected</c:if>>1학년</option>
	<option value="2" <c:if test="${param.searchGrade == '2' }">selected</c:if>>2학년</option>
	<option value="3" <c:if test="${param.searchGrade == '3' }">selected</c:if>>3학년</option>
	<option value="4" <c:if test="${param.searchGrade == '4' }">selected</c:if>>4학년</option>
</select><br>
학과:
<input type="checkbox" name="searchMajor" value="101">컴퓨터공학과
<input type="checkbox" name="searchMajor" value="102">멀티미디어공학과
<input type="checkbox" name="searchMajor" value="103">소프트웨어공학과
<input type="checkbox" name="searchMajor" value="201">전자공학과
<input type="checkbox" name="searchMajor" value="202">기계공학과
<input type="checkbox" name="searchMajor" value="301">문헌정보학과<br>
<select name="searchType">  
	<option value="all">전체</option>
	<option value="id" <c:if test="${param.searchType == 'id'}">selected</c:if>>아이디</option>
	<option value="name" <c:if test="${param.searchType == 'name'}">selected</c:if>>이름</option>
</select>
검색어 : <input type="text" name="searchWord" value="${param.searchWord }"> 
<input type="submit" value="조회하기">
</form>
</body>
</html>