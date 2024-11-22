<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.Function" %>
<!-- jstl 사용하려면 taglib 써야함 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 테스트</h1>
	name : ${name }
	<br> 변수에 저장
	<br>
	<!-- page 저장소에 저장 -->
	<c:set var="id" value="hong" />
	변수 출력 :
	<c:out value="${id}" />
	/ ${id } / ${pageScope.id }
	<br> request값 출력 : ${name } /
	<c:out value="${name }" />
	<br> 조건 : name의 값이 '홍길동'과 같으면
	<c:if test="{$name eq '홍길동' }"> true인 경우 출력</c:if>
	<br> 조건 : name의 값이 '홍길동'과 다르면
	<c:if test="{$name ne '홍길동' }"> 다른 경우 출력</c:if>
	<br> 로그인이 되어 있는 경우
	<c:if test="${not empty loginSession }">
		<br>${loginSession.name }님 안녕하세요
	</c:if>
	<br>로그인이 되어 있지 않은 경우
	<c:if test="${empty loginSession}">
		<br>로그인 하세요.
	</c:if>
	<br> choose (여러개 중 하나)
	<c:choose>
		<c:when test='${id == "hong" }'>홍길동</c:when>
		<c:when test='${id == "hong" }'>홍길동</c:when>
		<c:otherwise>아무개</c:otherwise>
	</c:choose>
	<br> 반복(forEach)
	<br>
	<c:forEach var="member" items="${memberList }" varStatus="">
	${status.index }${member.id } / ${member.name } <br>
	</c:forEach>
	<br> 경로 : c:url => 자동으로 컨텍스트패스 추가
	<img src="<c:url value="a.png"/>">
	<img src="<%=request.getContextPath()%>/img/a.png">
	<br> 숫자 포맷팅 :
	<fmt:formatNumber value="${price }"></fmt:formatNumber>
	<br> 날짜 포맷팅 :
	<fmt:formatDate value="${date }" pattern="YYYY-MM-DD HH:MM:SS"></fmt:formatDate>

	instance 메서드 호출 : ${func.plus(1, 2) }
	<br> static 메서드 호출 : ${Function.minus(10, 2) }
	<br> 날짜 포맷팅2 : ${Function.dateFormat(date) }
</body>
</html>