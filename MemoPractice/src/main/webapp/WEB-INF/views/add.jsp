<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>

	</style>
</head>
<body>
	<!--  -->
	<div id ="main">
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<div id="content">
			<h2>메모 쓰기2</h2>
	
			<form method="POST" action="/memopractice/addok.do">
			<table class="vertical">
				<tr>
					<th>메모</th>
					<td><textarea name="memo" required class="long"></textarea></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required class="short"></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type="password" name="pw" required class="short"></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="쓰기">
				<input type="button" value="뒤로가기" onclick="location.href='/memopractice/list.do';">
			</div>
			</form>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
	</script>
</body>
</html>