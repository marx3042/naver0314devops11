package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	SimpleBoardDao dao=new SimpleBoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//num,currentPage 를 읽는다
		int num=Integer.parseInt(request.getParameter("num"));
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		
		//조회수 증가
		dao.updateReadcount(num);
		
		//num 에 해당하는 dto 얻기
		SimpleBoardDto dto=dao.getData(num);
		
		//request 에 dto,currentPage 저장
		request.setAttribute("dto", dto);
		request.setAttribute("currentPage", currentPage);
		
		RequestDispatcher rd=request.getRequestDispatcher("../day0514/detail.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}