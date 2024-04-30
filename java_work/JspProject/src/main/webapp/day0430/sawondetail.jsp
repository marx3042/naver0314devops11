<%@page import="data.dto.SawonDto"%>
<%@page import="data.dao.SawonDao"%>
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
	//num
	int num=Integer.parseInt(request.getParameter("num"));
	//dao
	SawonDao dao=new SawonDao();
	//dto
	SawonDto dto=dao.getData(num);
%>
<body>
<div style="margin: 20px;width: 500px">
	<table>
		<caption align="top">
			<h2><b><%=dto.getName() %> 사원정보</b></h2>
		</caption>
		<tr>
			<td width="250">
				<img style="width: 230px;"
				src='<%=dto.getPhoto().equals("no")?"../image/noimage1.png":dto.getPhoto()%>'>
			</td>
			<td>
				<h5>나이 : <%=dto.getAge() %>세</h5>
				<h5>입사일 : <%=dto.getBirthday() %></h5>
				<h5>부서명 : <%=dto.getBuseo() %></h5>
				<h5>성 별 : <%=dto.getGender() %></h5>
				<h5>주 소 : <%=dto.getAddr() %></h5>				
			</td>
		</tr>
		<tr height="60">
			<td colspan="2" align="center">
				<button type="button" class="btn btn-sm btn-warning"
				style="width: 80px;"
				onclick="location.href='sawonform.jsp'">사원추가</button>
				
				<button type="button" class="btn btn-sm btn-warning"
				style="width: 80px;"
				onclick="location.href='sawonlist.jsp'">사원목록</button>
				
				<button type="button" class="btn btn-sm btn-warning"
				style="width: 80px;"
				onclick="location.href='sawonupdateform.jsp?num=<%=dto.getNum()%>'">정보수정</button>
				
				<button type="button" class="btn btn-sm btn-warning"
				style="width: 80px;"
				id="delsawon" num="<%=dto.getNum()%>"
				 sawonname="<%=dto.getName()%>">사원삭제</button>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	//사원삭제버튼 이벤트
	$("#delsawon").click(function(){
		let num=$(this).attr("num");
		let sawonname=$(this).attr("sawonname");
		let a=confirm(sawonname+" 사원정보를 삭제할까요?");
		if(a){
			location.href="sawondelete.jsp?num="+num;
		}
	});
</script>
</body>
</html>















