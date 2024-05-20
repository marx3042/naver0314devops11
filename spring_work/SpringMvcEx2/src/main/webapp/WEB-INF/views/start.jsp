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
       
       a:link,a:visited{
       	text-decoration: none;
       	color:black;
       }
   </style>
</head>
<body>
	<h3>폼태그를 읽는 다양한 방법 학습</h3>
	<ul style="font-size: 1.5em;">
		<li>
			<a href="./form1">get방식 폼 데이타 읽기-각각</a>
		</li>
		<li>
			<a href="./form2">post방식 폼 데이타 읽기-각각</a>
		</li>
		<li>
			<a href="./form3">post방식 폼 데이타 읽기-dto</a>
		</li>
		<li>
			<a href="./form4">post방식 폼 데이타 읽기-map</a>
		</li>
		<li>
			<a href="./uploadform1">이미지 1개 업로드</a>
		</li>
		<li>
			<a href="./uploadform2">이미지 여러개 업로드</a>
		</li>
	</ul>
</body>
</html>