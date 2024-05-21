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
	
	//��ȯŸ���� json ���·� {"count":0}
	@ResponseBody
	@GetMapping("/idcheck")
	public Map<String, Integer> searchId(
			@RequestParam String searchid
			)
	{
		Map<String, Integer> map=new HashMap<>();
		//db �� �ش� ���̵� �ִ��� üũ(0:����,1:����)
		int count=memberService.getSearchId(searchid);
		map.put("count", count);
		
		return map;
	}
}
















