<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//브라우저에 저장된 쿠키들을 얻는다
	Cookie []cookies=request.getCookies();
	//여러쿠키중 amho 를 찾아 유지시간을 0으로 만들어서 다시 브라우저에 추가한다
	if(cookies!=null){
		for(Cookie ck:cookies){
			if(ck.getName().equals("amho")){
				ck.setMaxAge(0);
				ck.setPath("/");
				response.addCookie(ck);
				break;
			}
		}
	}
	
	//다시 메인으로 이동
	response.sendRedirect("cookiemain.jsp");
%>