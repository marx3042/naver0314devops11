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
	<table class="table tatble-bordered" style="widows: 100%">
		<caption align="top"><h3><b>구구단</b></h3></caption>
		<tr>
		<% for(int i = 2; i <= 9; i++){ %>
				<td align="center"><b><%=i %>단</b></td>		
		<% } %>
		</tr>
		
		<tr>		
		<% for(int i = 1; i <= 9; i++){ %>
			<tr>
			<% for(int j = 2; j <= 9; j++){ %>
					<td align="center"><%=j+"X"+i+"="+(i*j) %></td>
			<% } %>
			</tr>
		<% } %>
		</tr>
	</table>
</body>
</html>