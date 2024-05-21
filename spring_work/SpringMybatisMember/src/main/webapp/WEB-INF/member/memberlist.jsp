<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}
</style>
</head>
<body>
	<h2 class="alert alert-danger" style="width: 500px;">
		총 ${totalCount}명의 회원이 있습니다 <span style="float: right;">
			<button type="button" class="btn btn-sm btn-success"
				onclick="location.href='./form'">멤버등록</button>
		</span>
	</h2>


	<caption>
		<b>[표 1]</b>
	</caption>
	<table>
		<tr style="border: solid 1px;">
			<td width=100 style="text-align: center; border: solid 1px gray;">번호</td>
			<td width=100 style="text-align: center; border: solid 1px gray;">이름</td>
			<td width=100 style="text-align: center; border: solid 1px gray;">아이디</td>
			<td width=100 style="text-align: center; border: solid 1px gray;">주소</td>
			<td width=100 style="text-align: center; border: solid 1px gray;">핸드폰</td>
			<td width=100 style="text-align: center; border: solid 1px gray;">이메일</td>
			<td width=100 style="text-align: center; border: solid 1px gray;">사진</td>
			<td width=100 style="text-align: center; border: solid 1px gray;">생일</td>
			<td width=100 style="text-align: center; border: solid 1px gray;">가입일</td>
		</tr>
		<c:forEach var="s" begin="0" end="${totalCount }" items="${list }">
			<tr>
				<td width=100>${s.num }</td>
				<td width=100>${s.name }</td>
				<td width=100>${s.myid }</td>
				<td width=100>${s.addr }</td>
				<td width=100>${s.hp }</td>
				<td width=100>${s.email }</td>
				<td width=100> <img src="../image/${s.photo }" width=100></td>
				<td width=100>${s.birthday }</td>
				<td width=100>${s.gaipday }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>