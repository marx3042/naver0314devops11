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
<button type="button" class="btn btn-sm btn-outline-success"
onclick="location.href='./form'">
	<i class="bi bi-pencil-fill"></i>
	글쓰기
</button>
<div style="margin: 20px;font-size: 25px;">
	총 ${totalCount}개의 게시글이 있습니다.
</div>
<table class="table table-striped" style="width: 600px;">
	<tr class="table-danger">
		<th width="50">번호</th>
		<th width="280">제목</th>
		<th width="100">작성자</th>
		<th width="120">작성일</th>
		<th>조회</th>		
	</tr>
	<c:if test="${totalCount==0}">
		<tr height="70">
			<td colspan="5" align="center" valign="middle">
				<h4>등록된 게시글이 없습니다</h4>
			</td>
		</tr>
	</c:if>
	<c:if test="${totalCount>0}">
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${no}</td>
				<!-- 증감연산자가 없으므로 1씩 감소후 다시 저장 -->
				<c:set var="no" value="${no-1}"/>
				
				<td> <!-- 제목은 클릭시 디테일 페이지로 이동하는데 num 을 넘겨야한다
				페이징처리시 현재페이지도 같이 넘겨야한다 -->
					<a href="./detail?num=${dto.num}&currentPage=${currentPage}" 
					style="text-decoration: none;color:black">
					${dto.subject}
					</a>
				</td>
				<td>${dto.writer }</td>
				<td>
					<fmt:formatDate value="${dto.writeday}"
					pattern="yyyy-MM-dd"/>
				</td>
				<td>${dto.readcount}</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<!-- 페이지 번호 출력 -->
<div style="width: 600px;text-align: center;font-size: 22px;">
	<!-- 
	이전: startPage가 1보다 클경우 이전이 보이도록 설정하는데
	이전을 클릭할경우 전블럭의 마지막 페이지가 현재페이지가 되어야한다
	 -->
	 <c:if test="${startPage>1}">
		 <a href="./list?currentPage=${startPage-1}"
		 style="text-decoration: none;color:black;">&lt;</a>
	 </c:if>
	 &nbsp;
	<c:forEach var="pp" begin="${startPage}" end="${endPage}">
		<a href="./list?currentPage=${pp}"
		  style="text-decoration: none;color:${currentPage==pp?'red':'black'}">
		  ${pp}</a>&nbsp;
	</c:forEach>
	
	<!-- 다음:endPage가 totalPage 보다 작다면 다음이 필요하다
	그런데 다음을 누를경우 다음블럭의 첫페이지가 현재페이지가 되어야만 한다 -->
	&nbsp;
	<c:if test="${endPage<totalPage}">
		<a href="./list?currentPage=${endPage+1}"
		 style="text-decoration: none;color:black;">&gt;</a>
	</c:if>
</div>
</body>
</html>