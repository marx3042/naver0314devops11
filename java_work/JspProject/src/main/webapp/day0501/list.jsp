<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.StudentDto"%>
<%@page import="java.util.List"%>
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
    </style>
</head>
<%
	//dao 선언
	StudentDao dao=new StudentDao();
	//list 가져오기
	List<StudentDto> list=dao.getAllStudent();
	//날짜 포멧
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd.");
%>
<body>
<div style="margin: 20px;width: 400px;">
	<table  class="table table-striped">
		<caption align="top">
			<b>학생 정보</b>
			<button type="button" class="btn btn-sm btn-info"
			onclick="location.href='writeform.jsp'"
			style="float: right;">학생정보추가</button>
		</caption>
		<tr class="table-danger">
			<th width="130">학생명</th>
			<th width="150">등록일자</th>
			<th>상세보기</th>
		</tr>
		<%
		for(StudentDto dto:list)
		{%>
			<tr>
				<td><%=dto.getName() %></td>
				<td><%=sdf.format(dto.getWriteday()) %></td>
				<td>
					<button type="button" class="btn btn-sm btn-outline-secondary"
					onclick="location.href='detail.jsp?num=<%=dto.getNum()%>'">상세보기</button>
				</td>
				
			</tr>
		<%}
		%>
	</table>
</div>
</body>
</html>