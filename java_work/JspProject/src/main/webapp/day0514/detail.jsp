<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
<body>
<div style="margin: 30px;">
	<table  class="table" style="width: 400px;">
		<tr>
			<td>
				<h2><b>${dto.subject}</b></h2>
				<div>
					<b>${dto.writer}</b>
					<span style="color:gray;font-size:16px;float:right">
						<fmt:formatDate value="${dto.writeday}"
						pattern="yyyy-MM-dd HH:mm"/>
					</span>
				</div>
				<b style="color:gray;clear: both;">조회 : ${dto.readcount}</b>
				<b style="margin-left:10px;color:gray;">추천
				&nbsp;<span class="chu">${dto.chu}</span></b>
				&nbsp;
				<i class="bi bi-hand-thumbs-up mychu"
				style="font-size: 20px;cursor: pointer;"></i>
				<br>
			</td>
		</tr>
		<tr>
			<td>
				<img src="../image/s${dto.avata}.JPG">
				<br>
				<pre style="font-size: 22px;">${dto.content}</pre>
			</td>
		</tr>
		<tr>
			<td align="center">
				<button type="button" class="btn btn-sm btn-success"
					style="width: 80px;"
					onclick="location.href='./form'">글쓰기</button>
					
				<button type="button" class="btn btn-sm btn-success"
					style="width: 80px;"
					onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
					
				<button type="button" class="btn btn-sm btn-success"
					style="width: 80px;" onclick="del()">삭제</button>
					
				<button type="button" class="btn btn-sm btn-success"
					style="width: 80px;"
					onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
			</td>
		</tr>
	</table>	
</div>
<script type="text/javascript">

	function del()
	{
		let num=${dto.num};
		let cp=${currentPage};
		console.log(num,cp);
		
		let a=confirm("해당 게시글을 삭제하시겠습니까?");
		if(a){
			location.href=`./delete?num=\${num}&currentPage=\${cp}`;
		}
	}
</script>
</body>
</html>