<%@page import="test.data.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
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
        div.shop{
	        float: left;
	        margin: 5px;
	        border: 2px solid; gray;
	        border-radius: 20px;
	        padding: 5px;
	        width: 200px;
	        height: 250px;         
        }
    </style>

</head>
<body>
	<%
		List list = new Vector();
		
		//5개 상품 리스트에 등록
		list.add(new ShopDto("보석머리띠", "30.jpg", 23000, 3, "orange"));
		list.add(new ShopDto("화이트자켓", "31.jpg", 35000, 3, "pink"));
		list.add(new ShopDto("꽃머리끈", "26.jpg", 8000, 3, "yellow"));
		list.add(new ShopDto("플렛슈즈", "14.jpg", 32000, 2, "green"));
		list.add(new ShopDto("QmEltmzkvm", "10.jpg", 67000, 3, "hotpink"));
		
	%>
</body>
</html>