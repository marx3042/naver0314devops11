package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.service.MemberService;

@Controller
@RequestMapping("/member")  //°øÅë¸ÅÇÎ
@RequiredArgsConstructor
public class MemberListController {
	
	//@Autowired
	
	@NonNull
	private MemberService memberService;
	
	@GetMapping("/list")
	public String list(Model model)
	{
		int totalCount;//ÃÑ °¹¼ö
		
		totalCount=memberService.getTotalCount();
		model.addAttribute("totalCount", totalCount);
		
		return "member/memberlist";
	}

}
