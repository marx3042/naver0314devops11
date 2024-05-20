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
	<h3 class="alert alert-danget">Get 방식으로 각각</h3>
	<form action="./read1" method="get">
		<div class="input-group" style="width: 300px;">
			<h4>이름</h4>
			<input type="text" name="name" class="form-control">		
		</div>
		<div class="input-group" style="width: 300px;">
			<h4>주소</h4>
			<input type="text" name="addr" class="form-control">		
		</div>
		<div class="input-group" style="width: 300px;">
			<h4>나이</h4>
			<input type="text" name="age" class="form-control">		
		</div>
		<button type="submit" class="btn btn-success">서버 전송</button>
	</form>
</body>
</html>