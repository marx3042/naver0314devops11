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
    </style>
</head>
<%
	//amho 라는 쿠키가 있으면 true,없으면 false
	boolean findAmho=false;
	Cookie []cookies=request.getCookies();
	if(cookies!=null)
	{
		for(Cookie ck:cookies){
			String name=ck.getName();
			if(name.equals("amho")){
				findAmho=true;
				break;
			}				
		}
	}
%>
<body>
<%
	if(findAmho){%>
		<jsp:include page="logoutform.jsp"/>
	<%}else{%>
		<jsp:include page="loginform.jsp"/>
	<%}
	%>
	<hr>
	<h3>오늘의 주요 기사들</h3>
	<jsp:include page="paper.jsp"/>
</body>
</html>