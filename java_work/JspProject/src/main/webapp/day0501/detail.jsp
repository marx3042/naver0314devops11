<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.StudentDto"%>
<%@page import="data.dao.StudentDao"%>
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
        	margin: 20px 100px;
        	border: 2px solid gray;
        	padding: 10px;
        	background-color: #ffffcc;
        	width: 400px;
        	height: auto;
        }
    </style>
</head>
<%
	//num int 타입
	int num=Integer.parseInt(request.getParameter("num"));
	//dao 선언
	StudentDao dao=new StudentDao();
	//dto 얻기
	StudentDto dto=dao.getData(num);
	//날짜 출력 양식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//총점
	int sum=dto.getJava()+dto.getSpring()+dto.getHtml();
	//평균
	double avg=sum/3.0;
	//소숫점이하 2자리
	NumberFormat nf=NumberFormat.getInstance();
	nf.setMaximumFractionDigits(2);
%>
<body>
<div class="box">
	<h5>이름 : <%=dto.getName() %></h5>
	<h5>혈액형 : <%=dto.getBlood() %>형</h5>
	<h5>운전면허: <%=dto.getLicense()=='y'?"있음":"없음" %></h5>
	<h5>Java점수 : <%=dto.getJava() %>점</h5>
	<h5>Spring점수 : <%=dto.getSpring() %>점</h5>
	<h5>HTML점수 : <%=dto.getHtml() %>점</h5>
	<h5>총점 : <%=sum %>점</h5>
	<h5>평균 : <%=nf.format(avg) %>점</h5>
	<hr>
	<button type="button" class="btn btn-sm btn-outline-secondary"
	onclick="location.href='writeform.jsp'"
	style="width: 100px;">학생정보추가</button>
	
	<button type="button" class="btn btn-sm btn-outline-secondary"
	onclick="location.href='list.jsp'"
	style="width: 100px;">학생목록</button>
	
	<br>
	
	<button type="button" class="btn btn-sm btn-outline-secondary"
	onclick="location.href='updateform.jsp?num=<%=dto.getNum() %>'"
	style="width: 100px;">학생정보수정</button>
	
	<button type="button" class="btn btn-sm btn-outline-secondary"
	id="delstu" num="<%=dto.getNum() %>" sname="<%=dto.getName()%>"
	style="width: 100px;">학생삭제</button>
</div>
</body>
</html>

















