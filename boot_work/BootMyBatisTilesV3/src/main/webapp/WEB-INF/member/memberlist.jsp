<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
       body *{
           font-family: 'Jua';
       }
   </style>
</head>
<body>
<h2 class="alert alert-danger" style="width: 500px;">
	총 ${totalCount}명의 회원이 있습니다
	<span style="float: right;">
		<button type="button" class="btn btn-sm btn-success"
		onclick="location.href='./form'">멤버등록</button>
	</span>
</h2>
<table class="table table-striped" style="width: 500px;">
	<caption align="top">
		<h3><b>회원명단</b></h3>
	</caption>
	<tr class="table-danger">
		<th width="50">번호</th>
		<th width="120">회원명</th>
		<th width="100">아이디</th>
		<th width="140">핸드폰</th>
		<th>상세보기</th>		
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="i">
		<tr>
			<td align="center">${i.count}</td>
			<td>
				<img src="../save/${dto.photo}" class="rounded-circle"
				style="width: 40px;height: 40px;"
				onerror="this.src='../image/noimage1.png'">
				${dto.name}
			</td>
			<td>${dto.myid}</td>
			<td>${dto.hp}</td>
			<td align="center">
				<button type="button" class="btn btn-sm btn-info"
				onclick="location.href='./detail?num=${dto.num}'">Detail</button>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>