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
        
        .selectavata{
        	border: 2px solid red;
        	box-shadow: 3px 3px 3px gray;
        	border-radius:5px; 
        }
    </style>
    <script type="text/javascript">
    $(function(){
    	$("img.avata").eq(0).addClass("selectavata");
    	
    	$("img.avata").click(function(){
    		$(this).siblings().removeClass("selectavata");//다른아바타의 class제거
    		$(this).addClass("selectavata");//클릭한곳에 class 추가
    		$("#avata").val($(this).attr("n"));//태그의 n값을 얻어서 input태그에 넣음
    	});
    });
    </script>
</head>
<body>
<div style="margin: 30px;">
	<form action="./insert" method="post">
		<table class="table table-bordered" style="width: 400px;">
			<caption align="top">
				<b>새글쓰기</b>
			</caption>
			<tr>
				<th class="table-success" width=100>작성자</th>
				<td>
					<input type="text" class="form-control"
					name="writer" required="required">
				</td>
			</tr>
			<tr>
				<th class="table-success" width=100>아바타</th>
				<td>
					<!--확인후 hidden 으로 수정할것임 -->
					<input type="hidden" name="avata" id="avata" value="1">
					<!-- 아바타 클릭시 1~10 사이 숫자가 hidden 에 들어가도록 제이쿼리로 코딩 -->
					<c:forEach var="a" begin="1" end="10">
						<c:if test="${a==6}"><br></c:if>
						
						<img src="../image/s${a}.JPG"
						width="40" height="40" border="1"
						class="avata" style="cursor: pointer;"
						n="${a}">
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th class="table-success" width=100>제목</th>
				<td>
					<input type="text" class="form-control"
					name="subject" required="required">
				</td>
			</tr>
			<tr>
				<th class="table-success" width=100>내용</th>
				<td>
					<textarea style="width: 100%;height: 120px;"
					name="content" required="required"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit"  
					class="btn btn-sm btn-success">게시글저장</button>
					
					<button type="button"  
					class="btn btn-sm btn-success"
					onclick="history.back()">이전으로</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>