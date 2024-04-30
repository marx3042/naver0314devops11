<%@page import="data.dto.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SawonDao"%>
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
        
        div.list{
        	float: left;
        	margin: 10px;
        	width: 150px;
        	height: 200px;
        	border: 1px solid gray;
        	box-shadow: 5px 5px 5px gray;
        	border-radius: 20px;
        	padding: 10px;
        	text-align: center;
        }
        div.list img{
        	border-radius: 20px;
        	width: 100px;
        	height: 110px;
        	margin-bottom: 10px;
        }
    </style>
</head>
<%
	//dao 선언
	SawonDao dao=new SawonDao();
	//list 가져오기
	List<SawonDto> list=dao.getAllSawons();
%>
<body>
<div style="margin: 20px;width: 500px;">
	  <div class="input-group">
		<h5 class="alert alert-danger" style="width: 400px;">총 <%=list.size() %>명의 사원이 있습니다</h5>
		<button type="button" class="btn btn-sm btn-info"
		onclick="location.href='sawonform.jsp'"
		style="margin-left: 10px;height: 50px;">사원추가</button>
	  </div>	 
</div>
 <%
	  for(SawonDto dto:list)
	  {%>
		<div class="list">
			<img 
			src='<%=dto.getPhoto().equals("no")?"../image/noimage1.png":dto.getPhoto()%>'>
			<br><%=dto.getName()%>사원
			<br>
			<button type="button" class="btn btn-sm btn-outline-danger"
			onclick="location.href='sawondetail.jsp?num=<%=dto.getNum()%>'">상세보기</button>
		</div>  
	  <%}
	  
	  %>
</body>
</html>

















