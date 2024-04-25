
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
	<h3>html주석과 jsp주석 비교하기</h3>
	<!-- html주석, <%= new Date() %> -->
	<%--jsp주석. <%=new Date()--%>
	
	<%!
		//선언문이라고 부륹다
		//여기서 선언하는 변수는 서블릿으로 변환시 위치 상관없이 맴버변수로 선언
		String name = "송혜교";
		int age = 30;
	%>
	<h5>이름2 : <%=name %></h5>
	<h5>나이2 : <%=age %></h5>
	
	<%
		//스크립트릿이라고 부른다(scriptlet)
		//자바영역:서블릿변환시 특정 메소드 내의 지경변수로 선언된다
		String addr="서울시 강남구";
		//내장객체중 out을 이용해서 출력해도 된다
		out.print("<h5 class='alert alert-danger'>나의 주소는 "+ addr + "입니다</h5>");
	%>
	<h5>주소 : <%=addr %></h5>
	
	
</body>
</html>