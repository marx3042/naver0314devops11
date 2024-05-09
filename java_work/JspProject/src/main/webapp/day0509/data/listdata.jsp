<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//검색단어 읽기
	String search=request.getParameter("search");
	GuestDao dao=new GuestDao();
    List<GuestDto> list=null;
    if(search==null || search.equals(""))
    	list=dao.getAllGuest();
    else
    	list=dao.getSearchGuest(search);
    
    JSONArray arr=new JSONArray();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    for(GuestDto dto:list)
    {
    	JSONObject ob=new JSONObject();
    	ob.put("num",dto.getNum());
    	ob.put("nickname",dto.getNickname());
    	ob.put("avata",dto.getAvata());
    	ob.put("content",dto.getContent());
    	ob.put("writeday",sdf.format(dto.getWriteday()));
    	
    	arr.add(ob);
    }    	
%>
<%=arr.toString()%>