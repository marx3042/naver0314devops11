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
    </style>
</head>
<%
	//1. num
	int num=Integer.parseInt(request.getParameter("num"));
	//2. dao
	StudentDao dao=new StudentDao();
	//3. dto
	StudentDto dto=dao.getData(num);
%>
<body>
<div style="margin: 10px;width: 400px;">
	<form action="./update.jsp" method="post">
	    <input type="hidden" name="num" value="<%=num%>">
		<table class="table table-bordered">
			<caption align="top"><b>학생정보수정</b></caption>
			<tr>
				<th class="table-warning" width="100">이름</th>
				<td>
					<input type="text" name="name" class="form-control"
					style="width: 130px;" required="required"
					value="<%=dto.getName()%>">
				</td>
			</tr>
			<tr>
				<th class="table-warning" width="100">혈액형</th>
				<td>
					<select class="form-select" style="width: 100px;" 
					name="blood">
						<option <%=dto.getBlood().equals("A")?"selected":"" %>>A</option>
						<option <%=dto.getBlood().equals("B")?"selected":"" %>>B</option>
						<option <%=dto.getBlood().equals("AB")?"selected":"" %>>AB</option>
						<option <%=dto.getBlood().equals("O")?"selected":"" %>>O</option>						
					</select>
				</td>
			</tr>
			<tr>
				<th class="table-warning" width="100">운전면허</th>
				<td>
					<label>
						<input type="checkbox" name="license"
						 <%=dto.getLicense()=='y'?"checked":"" %>>있음
					</label>
				</td>
			</tr>
			<tr>
				<th class="table-warning" width="100">자바점수</th>
				<td>
					<input type="number" name="java" class="form-control"
					style="width: 130px;" required="required"
					min="0" max="100" value="<%=dto.getJava()%>">
				</td>
			</tr>
			<tr>
				<th class="table-warning" width="100">Spring점수</th>
				<td>
					<input type="number" name="spring" class="form-control"
					style="width: 130px;" required="required"
					min="0" max="100" value="<%=dto.getSpring()%>">
				</td>
			</tr>
			<tr>
				<th class="table-warning" width="100">HTML점수</th>
				<td>
					<input type="number" name="html" class="form-control"
					style="width: 130px;" required="required"
					min="0" max="100" value="<%=dto.getHtml()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-info">
						학생정보저장
					</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>