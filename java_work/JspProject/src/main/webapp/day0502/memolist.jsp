<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.MemoDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MemoDao"%>
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
	//dao
	MemoDao dao=new MemoDao();
	//list
	List<MemoDto> list=dao.getAllMemo();
	//날짜 포켓
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
<div style="margin: 10px; width: 500px;">
	<table class="table table-striped">
		<caption align="top">
			<b>총 <%=list.size() %>개의 메모가 있습니다</b>
			<button type="button" class="btn btn-success btn-sm"
			style="float: right"
			onclick="location.href='memoform.jsp'">메모추가</button>
		</caption>
		<tr class="table-info">
			<th width="60">번호</th>
			<th width="300">제목</th>
			<th>작성일</th>			
		</tr>
		<%
		int n=0;
		for(MemoDto dto:list)
		{
			int no=list.size()-n++;
		%>
		<tr>
			<td align="center"><%=no%></td>
			<td>
				<a href="memodetail.jsp?num=<%=dto.getNum() %>" 
				style="text-decoration: none;color:black;">
				<%=dto.getTitle() %></a>
			</td>
			<td><%=sdf.format(dto.getWriteday()) %></td>
		</tr>
		<%}
		%>
	</table>
</div>
</body>
</html>