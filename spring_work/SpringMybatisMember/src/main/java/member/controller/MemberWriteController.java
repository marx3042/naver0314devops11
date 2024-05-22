package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import member.dto.MemberDto;
import member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberWriteController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/form")
	public String form()
	{
		return "member/writeform";
	}
	
	//반환타입이 json 형태로 {"count":0}
	@ResponseBody
	@GetMapping("/idcheck")
	public Map<String, Integer> searchId(
			@RequestParam String searchid
			)
	{
		Map<String, Integer> map=new HashMap<>();
		//db 에 해당 아이디가 있는지 체크(0:없음,1:있음)
		int count=memberService.getSearchId(searchid);
		map.put("count", count);
		
		return map;
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute MemberDto dto,
			@RequestParam("myfile") MultipartFile myfile,
			HttpServletRequest request
			)
	{
		//업로드 경로 구하기
		String uploadPath=request.getSession().getServletContext().getRealPath("/resources");
		System.out.println(uploadPath);
		
		//업로드된 파일명을 dto 의 photo 에 저장
		String photo=myfile.getOriginalFilename();
		dto.setPhoto(photo);
		
		//업로드
		try {
			myfile.transferTo(new File(uploadPath+"/"+photo));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//db 에 insert
		memberService.insertMember(dto);
		
		//목록페이지로 이동
		return "redirect:./list";
	}
}