<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//idx int 타입으로 읽기
	int idx=Integer.parseInt(request.getParameter("idx"));
	//dao
	ShopDao dao=new ShopDao();
	//list
	List<ShopDto> list=dao.getShopDatas(idx);
	
	//날짜 포멧
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	//json으로 변환
	JSONArray arr=new JSONArray();
	for(ShopDto dto:list){
		JSONObject ob=new JSONObject();
		ob.put("shopidx",dto.getShopidx());
		ob.put("sname",dto.getSname());
		ob.put("sprice",dto.getSprice());
		ob.put("scount",dto.getScount());
		ob.put("scolor",dto.getScolor());
		ob.put("sphoto",dto.getSphoto());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		arr.add(ob);		 
	}
%>
<%=arr.toString()%>