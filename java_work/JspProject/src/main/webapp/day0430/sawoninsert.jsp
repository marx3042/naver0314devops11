<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이번에는 jsp 의 기능인 자바빈즈를 이용해서 자동으로 읽어보자
단 폼태그의 name과 dto의 변수명이 같은것에 한해서만 읽어온다 -->

<%
	//한글 엔코딩
	request.setCharacterEncoding("utf-8");
%>    
<!-- jsp 액션태그를 이용해서 dto,dao 를 선언해보자 -->
<jsp:useBean id="dto" class="data.dto.SawonDto"/>
<jsp:useBean id="dao" class="data.dao.SawonDao"/>
<!-- 자동으로 데이타 읽어서 dto 에 넣기 :property에 dto의 변수명을 쓰면 해당 데이타만 
읽어오지만 *를 쓰면 모든 데이타를 읽어온다-->
<jsp:setProperty name="dto" property="*"/>
<%
	//insert 메서드 호출
	dao.insertSawon(dto);
	//사원목록으로 이동
	response.sendRedirect("sawonlist.jsp");
%>