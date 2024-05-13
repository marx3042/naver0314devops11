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
<h5 class="alert alert-danger">JSTL 공부 #4- forEach문</h5>
<h6>1부터 10까지 출력</h6>
<c:forEach var="a" begin="1" end="10">
	<b>${a}</b>&nbsp;
</c:forEach>
<h6>1부터 20까지 홀수만 출력</h6>
<c:forEach var="a" begin="1" end="20" step="2">
	<b>${a}</b>&nbsp;
</c:forEach>
<h6>list1 출력(index 0~3까지만 출력)</h6>
<table class="table table-striped" style="width: 300px;">
	<tr>
		<th width="50">count</th>
		<th width="50">index</th>
		<th width="100">색상값</th>
		<th>색상</th>
	</tr>
	<c:forEach var="s" begin="0"  end="3" items="${list1}" varStatus="n">
		<tr>
			<td>${n.count}</td>
			<td>${n.index}</td>
			<td>${s}</td>
			<td style="background-color: ${s}"></td>
		</tr>
	</c:forEach>
</table>
<h6>list1 출력(index 2~4까지만 출력)</h6>
<table class="table table-striped" style="width: 300px;">
	<tr>
		<th width="50">count</th>
		<th width="50">index</th>
		<th width="100">색상값</th>
		<th>색상</th>
	</tr>
	<c:forEach var="s" begin="2"  end="4" items="${list1}" varStatus="n">
		<tr>
			<td>${n.count}</td>
			<td>${n.index}</td>
			<td>${s}</td>
			<td style="background-color: ${s}"></td>
		</tr>
	</c:forEach>
</table>
<hr>
<h6>forTokens : , 로 문자열 분리해서 출력하기</h6>
<h6>${flowers}</h6>
<c:forTokens var="a" items="${flowers}" delims="," varStatus="n">
	<h6>${n.count}: ${a}</h6>
</c:forTokens>
</body>
</html>