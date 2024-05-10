<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//shopidx
	int shopidx=Integer.parseInt(request.getParameter("shopidx"));
	//dao
	ShopDao dao=new ShopDao();
	//삭제
	dao.deleteShop(shopidx);
%>