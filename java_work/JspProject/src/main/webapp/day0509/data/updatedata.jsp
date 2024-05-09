<%@page import="org.json.simple.JSONObject"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	GuestDao dao=new GuestDao();
	GuestDto dto=dao.getData(num);
	
	JSONObject ob=new JSONObject();
	ob.put("num",dto.getNum());
	ob.put("nickname",dto.getNickname());
	ob.put("content",dto.getContent());
%>
<%=ob.toString()%>