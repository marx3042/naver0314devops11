<%@page import="data.dao.MemoDao"%>
<%@page import="data.dto.MemoDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //업로드되는 이미지의 사이즈
	int uploadSize=1024*1024*5;//5mb
	//실제 업로드되는 경로구하기
	//코드가 있는 프로젝트로 업로드되는것이 아니라
	//톰켓서버에 배포된 프로젝트안의 save 폴더에 업로드가 된다
	ServletContext context=getServletContext();
	String realFolder=context.getRealPath("/save");
	System.out.println("realFolder="+realFolder);//실제 업로드되는 save 폴더의 경로
	
	MultipartRequest multi=null;
	try{
		multi=new MultipartRequest(request,realFolder,uploadSize,"utf-8",
				new DefaultFileRenamePolicy());//마지막 인자: 같은 이름이 업로드될경우 이름 변경
		//데이타 읽기
		String title=multi.getParameter("title");
		String content=multi.getParameter("content");
		//파일은 실제 업로드된 파일명을 얻는다
		String uploadPhoto=multi.getFilesystemName("upload");
		
		//dto 선언후 데이타 넣기
		MemoDto dto=new MemoDto();
		dto.setTitle(title);
		dto.setUploadPhoto(uploadPhoto);
		dto.setContent(content);
		
		//dao 선언
		MemoDao dao=new MemoDao();
		
		//insert후 목록으로 이동
		dao.insertMemo(dto);
		response.sendRedirect("memolist.jsp");
		
	}catch(Exception e){%>
		<script>
			alert("파일 업로드 오류:"+e.getMessage());
		</script>
	<%}	
%>