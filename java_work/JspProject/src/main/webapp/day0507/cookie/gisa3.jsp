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

송가인, 

(엑스포츠뉴스 김예나 기자) 가수 송가인이 과거 힘들었던 무명 생활을 
올리며 의미심장한 글을 남겨 화제를 모으고 있다.

송가인은 지난 6일 개인 채널을 통해 "무명 시절 정말 정말 힘이 
되어주시고 방패가 되어주시고 속앓이를 함께해주셨던 우리 대표님. 
그때 그 힘든 시절 할 말이 많지만 생략"이라고 글을 남겼다.

AD

기사 이미지

이어 "#사필귀정 #낭중지추 #최고의 복수는 성공이다"라는 
해시태그를 덧붙여 눈길을 끌었다.

이에 누리꾼들은 "꽃길만 걸으세요" "힘든 시절 함께해주셔서 감사합니다" 
"힘들 때 곁에 있어줘서 감사합니다" "최고의 복수는 성공이라는 말이 진리"
 "잘 이겨냈어요" 등 응원을 보내고 있다.

더불어 송가인이 과거 8년의 무명 시절을 겪으며 힘들었던 
당시를 떠올리던 일화가 재조명되고 있다.
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














