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
		$.ajax({
			type:'post',
			async:false,
			url:'/pro16/json2',
			dataType:'json',
			success:function(data) {
				var memberInfo = '회원 정보<br>';
				memberInfo += "=========<br>";
				for (var i in data.members) {
					memberInfo += "이름: "+data.members[i].name+"<br>";
					memberInfo += "나이: "+data.members[i].age+"<br>";
					memberInfo += "성별: "+data.members[i].gender+"<br>";
					memberInfo += "별명: "+data.members[i].nickname+"<br><br><br>";
				}
				$("#output").html(memberInfo);
			}
		})
	})
})
</script>
</head>
<body>
<input type="button" id="checkJson" value="JSON 전송">
<div id="output"></div>
</body>
</html>