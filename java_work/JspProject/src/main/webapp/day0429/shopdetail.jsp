<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
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
	//shopidx int 타입으로 읽기
	int shopidx=Integer.parseInt(request.getParameter("shopidx"));
	//dao 선언
	ShopDao dao=new ShopDao();
	//dto 데이타 가져오기
	ShopDto dto=dao.getSangpum(shopidx);
	//날짜 포멧양식 지정
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div style="margin: 10px;width: 500px;">
	<h2><b>상품명 : <%=dto.getSname() %></b></h2>
	<span style="font-size: 14px;color: gray;">
		등록일 : <%=sdf.format(dto.getWriteday()) %>
	</span>
	
	<table>
		<tr>
			<td width="300">
				<img src="<%=dto.getSphoto()%>"
				 style="border: 10px groove orange;margin:10px;width:270px;">
			</td>
			<td>
				<h5>가 격 : <%=dto.getSprice() %>원</h5>
				<h5 style="background-color: <%=dto.getScolor()%>">
					색 상 : <%=dto.getScolor() %>
				</h5>
				<h5>수 량 : <%=dto.getScount() %>개</h5>
				<h5>총금액 : <%=dto.getScount()*dto.getSprice() %>원</h5>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-outline-danger btn-sm"
				style="width: 80px;"
				onclick="location.href='shoplist.jsp'">목록</button>
				
				<button type="button" class="btn btn-outline-danger btn-sm"
				style="width: 80px;"
				onclick="location.href='shopupdateform.jsp?shopidx=<%=dto.getShopidx()%>'">수정</button>
				
				<button type="button" class="btn btn-outline-danger btn-sm"
				style="width: 80px;"
				onclick="location.href='shopdelete.jsp?shopidx=<%=dto.getShopidx()%>'">삭제1</button>
				
				<button type="button" class="btn btn-outline-danger btn-sm"
				style="width: 80px;" shopidx="<%=shopidx%>"
				id="delshop">삭제2</button>
				
				<button type="button" class="btn btn-outline-danger btn-sm"
				style="width: 80px;"
				onclick="location.href='shopform.jsp'">상품추가</button>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
//삭제2버튼 이벤트
$("#delshop").click(function(){
	let shopidx=$(this).attr("shopidx");
	let a=confirm(`\${shopidx} 번 상품을 삭제할까요?`);//jsp에서는 $기능이 이미 있으므로 스크립트에서 변수를 넣을경우 \${변수명}
	if(a){
		location.href="shopdelete.jsp?shopidx="+shopidx;//페이지 이동
	}
});
</script>
</body>
</html>