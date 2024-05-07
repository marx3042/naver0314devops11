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
	//amho 라는 쿠키가 있으면 true,없으면 false
	boolean findAmho=false;
	Cookie []cookies=request.getCookies();
	if(cookies!=null)
	{
		for(Cookie ck:cookies){
			String name=ck.getName();
			if(name.equals("amho")){
				findAmho=true;
				break;
			}				
		}
	}
%>
<body>
<%
if(findAmho){%>
<pre>
"'증원 확정시 1주 휴진' 계획 의대교수들, 집단행동 멈춰야"
정부 "비상진료 건강보험 지원 한달 더 연장…상황 장기화 대비"

(서울=연합뉴스) 김병규 기자 = 정부가 의사 집단행동 장기화에 
대비해 비상진료에 대한 건강보험 지원을 한 달 더 연장하기로 했다.

또 의대 교수들이 의대증원이 확정되면 1주일 휴진을 하겠다고 
밝힌 것에 대해서는 집단행동을 멈추라고 촉구했다.

AD
조규홍 보건복지부 장관은 7일 정부서울청사에서 의사 집단행동 
중앙재난안전대책본부(중대본) 회의를 주재하고 
"향후 비상진료 상황이 장기화할 가능성에 대비해 건강보험 지원을 11일부터 
한 달간 연장할 계획"이라고 밝혔다.
</pre>
<%}else{%>
	<script type="text/javascript">
		alert("먼저 암호를 입력해주세요");
		history.back();
	</script>
<%}
%>
</body>
</html>