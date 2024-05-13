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
<h5 class="alert alert-danger">JSTL 공부 #5- if,choose문</h5>
<fmt:requestEncoding value="utf-8"/>
<form action="./study5" method="post">
	<input type="text" name="nara">
	<br>
	<button type="submit">전송</button>
</form>
<h6>입력값은 ${param.nara}</h6>
<c:choose>
	<c:when test="${param.nara=='하와이'}">
		<img src="./image/s1.JPG" width="50">
		<b style="color: red;background-color: yellow">
			하와이는 바다가 아름다운 나라입니다</b>
	</c:when>
	<c:when test="${param.nara=='미국'}">
		<img src="./image/s5.JPG" width="50">
		<b style="color: white;background-color: black">
			미국은 자유의여신상이 아름다운 나라입니다</b>
	</c:when>
	<c:when test="${param.nara=='프랑스'}">
		<img src="./image/s6.JPG" width="50">
		<b style="color: pink;background-color: black">
			프랑스는 에펠탑이 아름다운 나라입니다</b>
	</c:when>
	<c:when test="${param.nara=='스위스'}">
		<img src="./image/s3.JPG" width="50">
		<b style="color: green;background-color: blue">
			스위스는 알프스 산맥이 아름다운 나라입니다</b>
	</c:when>
	<c:otherwise>
		<img src="./image/s10.JPG" width="50">
		<b style="color: red;background-color: yellow">
			${param.nara} 는 어디가 아름다운 나라인가요??</b>
	</c:otherwise>
</c:choose>
</body>
</html>