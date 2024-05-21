package member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
















