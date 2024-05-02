<%@page import="data.dao.StudentDao"%>
<%@page import="data.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 엔코딩
	request.setCharacterEncoding("utf-8");
	//데이타 읽기(license 경우는 체크하면 y, 안할경우 n 을 저장)
	int num=Integer.parseInt(request.getParameter("num"));
	String name=request.getParameter("name");
	String blood=request.getParameter("blood");
	int java=Integer.parseInt(request.getParameter("java"));
	int spring=Integer.parseInt(request.getParameter("spring"));
	int html=Integer.parseInt(request.getParameter("html"));
	char license=request.getParameter("license")==null?'n':'y';
	
	//dto 선언후 데이타 넣기
	StudentDto dto=new StudentDto();
	dto.setNum(num);
	dto.setName(name);
	dto.setBlood(blood);
	dto.setJava(java);
	dto.setSpring(spring);
	dto.setHtml(html);
	dto.setLicense(license);
	
	//dao선언후 메서드 호출
	StudentDao dao=new StudentDao();
	dao.updateStudent(dto);
	//상세보기로 이동
	response.sendRedirect("detail.jsp?num="+num);
%>