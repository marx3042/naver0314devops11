<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//shopidx int 타입으로 읽기
	int shopidx=Integer.parseInt(request.getParameter("shopidx"));
	//dao 선언
	ShopDao dao=new ShopDao();
	//delete메서드 호출
	dao.deleteShop(shopidx);
	//목록 shoplist.jsp 로 이동
	response.sendRedirect("shoplist.jsp");
%>