package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.ReBoardDto;
import data.service.MemberService;
import data.service.ReBoardService;

@Controller
@RequestMapping("/board")
public class BoardWriteController {
	@Autowired
	private ReBoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/form")
	public String form(
			//새글일경우 null 값들이 넘어오므로 초기값을 지정한다
			//답글일경우는 원글이 갖고있는 각종 정보가 넘어온다
			@RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int regroup,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "1") int currentPage,
			Model model
			)
	{
		//답글일경우 제목을 얻어서 model 에 저장한다
		String subject="";
		if(num>0) {
			subject="[답글]"+boardService.getData(num).getSubject();
		}
		model.addAttribute("num",num);
		model.addAttribute("regroup",regroup);
		model.addAttribute("restep",restep);
		model.addAttribute("relevel",relevel);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("subject",subject);
		
		return "board/writeform";
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute ReBoardDto dto,
			@RequestParam("upload") MultipartFile upload,
			@RequestParam int currentPage,
			HttpServletRequest request,
			HttpSession session
			)
	{
		//업로드할 폴더
		String saveFolder=request.getSession().getServletContext().getRealPath("/save");
		//업로드하지 않았을경우 "no",업로드했을경우 랜덤파일명으로 저장
		String photo=upload.getOriginalFilename();
		if(photo.equals("")) {
			photo="no";
		}else {
			//확장자 분리
			String ext=photo.split("\\.")[1];
			photo=UUID.randomUUID()+"."+ext;
			
			//실제 폴더에 업로드
			try {
				upload.transferTo(new File(saveFolder+"/"+photo));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dto.setUploadphoto(photo);
		
		//세션으로부터 아이디 얻기
		String loginid=(String)session.getAttribute("loginid");
		dto.setMyid(loginid);
		
		//member db 로부터 아이디에 해당하는 이름을 얻어서 dto 에 저장
		String writer=memberService.getDataById(loginid).getName();
		dto.setWriter(writer);
		
		//db insert
		boardService.insertBoard(dto);
		
		//확인할거...추가후 저장된 시퀀스값
		System.out.println("num="+dto.getNum());
		
		//return "redirect:./list?currentPage="+currentPage;
		
		//추가후 상세페이지로 이동
		return "redirect:./detail?num="+dto.getNum()+"&currentPage="+currentPage;
	}
}