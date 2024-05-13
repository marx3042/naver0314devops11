<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
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
<h5 class="alert alert-danger">JSTL 공부 #3</h5>
<h5>list1 색상표 출력</h5>
<table class="table table-bordered" style="width:200px;">
	<tr>
		<th>번호</th><th>색상표</th><th>색상</th>
	</tr>
	<c:forEach var="s" items="${list1}" varStatus="i">
		<tr>
			<td>${i.count}</td>
			<td>${s}</td>
			<td style="background-color: ${s}"></td>
		</tr>
	</c:forEach>
</table>
<hr>
<h5>Shop 데이타 출력</h5>
<table class="table table-striped" style="width: 500px;">
	<tr>
		<th width="50">번호</th>
		<th width="150">상품명</th>
		<th width="100">가격</th>
		<th width="80">색상</th>
		<th>날짜</th>		
	</tr>
	<c:forEach var="dto" items="${shoplist}" varStatus="i">
		<tr>
			<td>${i.count}</td>
			<td>
				<img src="${dto.sphoto}" 
				style="width:40px;height:40px;border:1px solid gray;">
				${dto.sname}
			</td>
			<td align="right">
				<fmt:formatNumber value="${dto.sprice}" type="number"/>원
			</td>
			<td style="background-color: ${dto.scolor}">
				${dto.scolor}
			</td>
			<td>
				<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>