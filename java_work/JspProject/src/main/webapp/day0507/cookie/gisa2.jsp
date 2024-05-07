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
[톱스타뉴스 유혜지 기자]'나는 솔로' 16기 영숙이 최근 기자회견을 진행한 어도어 민희진 대표를 패러디했다.


지난 3일 영숙은 자신의 유튜브 채널을 통해 '24.05.03 오늘'이라는 제목의 라이브를 진행했다. 
상에서 영숙은 기자회견 속 민희진의 착장을 그대로 따라해 눈길을 모았다.




AD

'나는솔로' 16기 영숙, 민희진 패러디?…끝나지 않은 상철 저격



이날 영숙은 "1년이라는 시간이 흘렀다. 고소 파티하고 난리났던 
저는 한 여성이기 전에 먼저 한 아이의 엄마"라며 "저를 정말 정신머리 없는 
미XX을 만들던데 근데 제가 계속 무시하고 있었던 건 그게 더 이상 
대응할 가치가 없기 때문"이라고 밝혔다.
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