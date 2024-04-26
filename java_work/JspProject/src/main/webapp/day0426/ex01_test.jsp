<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
		body * {
			font-family: 'Jua';
		}
	</style>
</head>
<%
	String flowers[] = { "장미꽃", "안개꽃", "다알리아", "국화꽃", "프리지아" };
	String colors[] = { "orange", "pink", "yellow", "tomato", "gold" };
	List<String> list = Arrays.asList("2000원", "3500원", "5000원", "2300원", "9000원");
%>
<body>
	<table class="table table-bordered" style="width: 400px;">
		<caption align="top"><b>배열 및 리스트 출력</b></caption>
		<tr class="table=success">
			<th width="60">번호</th>
			<th width="120">꽃이름</th>
			<th width="120">단가</th>
			<th>색상</th>
		</tr>
		<%
			for(int i = 0; i < flowers.length; i++){
				%>
					<tr>
						<td align="center"><%=i+1 %></td>
						<td align="center"><%=flowers[i] %></td>
						<td align="center"><%=list.get(i) %></td>
						<td align="center" style="background-color: <%= colors[i]%>"><%=colors[i] %></td>
					</tr>
				
				<%
			}
		%>	
	</table>
</body>
</html>