<%@page import="data.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1. num 읽기
	int num=Integer.parseInt(request.getParameter("num"));
//2. dao 생성
	SawonDao dao=new SawonDao();
//3. 삭제 메서드 호출
	dao.deletetSawon(num);
//4. 목록으로 이동
	response.sendRedirect("sawonlist.jsp");
%>