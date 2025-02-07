<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function() {
	$("#checkJson").click(function() {
		var _jsonInfo = '{"name":"박지성","age":25, "gender":"남자", "nickname":"날센돌이"}';
		$.ajax({
			type:'post',
			async:false,
			url:'/pro16/json',
			data:{jsonInfo:_jsonInfo},
			success:function(data) {}
		})
	})
})
</script>
</head>
<body>
<input type="button" id="checkJson" value="JSON 전송">
</body>
</html>