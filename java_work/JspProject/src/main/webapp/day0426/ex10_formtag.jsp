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
	<h5>폼태그 읽기-문제</h5>
	 <form action="./ex10_action.jsp" method="post">
	 	<table class="table table-border" sytle="width: 400px;">
	 		<tr>
	 			<th class="table-info">메뉴명</th>
	 			<td>
	 				<input type="text" name="menuname" class="form-control" required="required" autofocus="autofocus">
	 			</td>
	 		</tr>
	 		<tr>
	 			<th class="table-info" width="100">음식사진</th>
	 			<td class="input-group">
	 				<select class="form-slect" name="foodphoto" id = "foodphoto">
	 					<option value="../image/1.jpg,9000">샌드위치</option>
	 					<option value="../image/8.jpg,11000">샌드위치</option>
	 					<option value="../image/11.jpg,13000">망고빙수</option>
	 					<option value="../image/10.jpg,8000">햄마요덮밥</option>
	 				</select>
	 				<img src="../image/3.jpg" id="photo" width="60" height="60" style="margin-left: 10px;">
	 			
	 			
	 			</td>
	 		</tr>
	 		
	 		
	 	</table>
	 </form>
</body>
</html>