<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">회원 정보 출력</h1>
<%
request.setCharacterEncoding("utf-8");
String _name = request.getParameter("name");
MemberVO memberVO = new MemberVO();
memberVO.setName(_name);

MemberDAO dao = new MemberDAO();
List<MemberVO> list = dao.listMembers(memberVO);
%>
<table border=1 width=800 align=center>
	<tr align=center bgcolor="#FFFF66">
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일자</td>
	</tr>
	<%
	for (int i=0; i<list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getId() %></td>
		<td><%=list.get(i).getPwd() %></td>
		<td><%=list.get(i).getName() %></td>
		<td><%=list.get(i).getEmail() %></td>
		<td><%=list.get(i).getJoinDate() %></td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>