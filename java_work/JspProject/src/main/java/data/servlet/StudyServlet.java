package data.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.ShopDao;
import data.dto.ShopDto;

/**
 * Servlet implementation class StudyServlet
 */
@WebServlet("/study3")
public class StudyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list1=Arrays.asList("orange","green","pink","gray","magenta","tomato");
		ShopDao dao=new ShopDao();
		List<ShopDto> shoplist=dao.getShopDatas();
		
		request.setAttribute("list1", list1);
		request.setAttribute("shoplist", shoplist);		
		//경로때문에 .. 을 . 으로 변경해서 보내보자
		for(ShopDto dto:shoplist) {
			dto.setSphoto(dto.getSphoto().replace("..", "."));
		}		
		
		RequestDispatcher rd=request.getRequestDispatcher("./day0513/test3.jsp");
		rd.forward(request, response);		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}