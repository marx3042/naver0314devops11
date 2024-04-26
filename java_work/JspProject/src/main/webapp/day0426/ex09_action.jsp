<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        
        div.box{
        	width: 100px;
        	height: 50px;
        	border: 1px solid gray;
        	text-align: center;
        	line-height: 50px;
        }
    </style>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String weight=request.getParameter("weight");
	String birth=request.getParameter("birth");
	String color=request.getParameter("color");
	String message=request.getParameter("message");
	String content=request.getParameter("content");
%>
<body>
<div style="margin: 30px;font-size: 20px;">
	생년월일 : <%=birth %><br>
	몸무게 : <%=weight %>Kg<br>
	좋아하는 색상
	<div class="box" style="background-color: <%=color%>"><%=color%></div>
	숨겨진 메세지 : <%=message %><br>
	하고싶은말<br>
	<%=content.replace("\n", "<br>") %>
	<hr>
	<pre><%=content %></pre>
</div>
</body>
</html>