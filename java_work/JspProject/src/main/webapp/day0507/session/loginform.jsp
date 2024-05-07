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
	String myid=(String)session.getAttribute("myid");
	String save=(String)session.getAttribute("saveok");
	//체크상태에 따라 아이디를 출력한다
	String writeid=save==null||save.equals("no")?"":myid;	
%>
<body>
<form action="./loginaction.jsp" method="post">
	<table class="table table-bordered" style="width:250px;">
		<caption align="top">
			<b>회원 로그인</b>
			<label>
				<input type="checkbox" name="save" 
				style="margin-left: 50px;"
				<%=writeid.length()==0?"":"checked" %>>아이디저장
			</label>
		</caption>
		<tr>
			<th width="100" class="table-success">아이디</th>
			<td>
				<input type="text" name="myid" class="form-control" value="<%=writeid%>">
			</td>
		</tr>
		<tr>
			<th width="100" class="table-success">비밀번호</th>
			<td>
				<input type="password" name="mypass" class="form-control">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-outline-danger">
				회원로그인</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>

















