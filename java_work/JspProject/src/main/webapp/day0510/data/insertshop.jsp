<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="data.dao.ShopDao"/>
<jsp:useBean id="dto" class="data.dto.ShopDto"/>
<jsp:setProperty property="*" name="dto"/><!-- 이름이 같은 데이타를 dto 에 넣는다 -->
<%
	dao.insertShop(dto);
%>