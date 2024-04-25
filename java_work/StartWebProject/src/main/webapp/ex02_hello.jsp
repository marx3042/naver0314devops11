<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}
</style>

</head>
<body>
	<h5>자바영역의 배열변수를 table을 이용해 출력</h5>
	<%
		String colors[] = {"red", "orange", "hotpink", "green", "gray"};
	%>
	<table class=" table table-striped" style="width: 200px">
		<caption align="top">
			<b>색상 배열 출력</b>
		</caption>
		<tr class="table-danger">
			<th>번호</th>
			<th>색상</th>
		</tr>
		<%
			for(int i = 0; i < colors.length; i++){
				%>
				<tr>
					<td><%=i+1 %></td>
					<td style="background-color: <%= colors[i]%>">
					<%=colors[i]+1 %></td>
				</tr>
				
			<%}
		%>
	</table>
	
	<%
		String name="신민아";
		String addr="서울시 강남구";
		int age = 32;
		String blood="AB형";
		String photo="./image/17.jpg";
		String hobby[]={"자바공부", "스프링공부", "제이쿼리공부", "게임", "웹툰"};
	%>
	<table class="table table-bordered" style="width= ">
		<tr>
			<td width="200" rowspan="4">
				<img src="<%= photo %>" width="190">
			</td>
			<td width="60" class="table-danger">이름</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td width="60" class="table-danger">나이</td>
			<td><%=age %></td> 
		</tr>
		<tr>
			<td width="60" class="table-danger">주소</td>
			<td><%= addr %></td> 
		</tr>
		<tr>
			<td width="60" class="table-danger">혈액형</td>
			<td><%=blood %></td> 
		</tr>
		<tr>
			<td colspan="3">
			<b>취미 : </b>
			<%
				for(String h : hobby){
					out.print("[" + h + "]");
				}
			%>
			</td>
		</tr>
	</table>
</body>
</html>
















