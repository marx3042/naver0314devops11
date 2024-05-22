package member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import member.dto.MemberDto;
import member.service.MemberService;

@Controller
public class MemberUpdateController {

	@Autowired
	private MemberService memberService;
	
	//수정폼-이름,핸드폰,이메일,주소,생년월일 만 폼에 나타나도록
	@GetMapping("/member/updateform")
	public String updateForm(@RequestParam int num,Model model)
	{
		//db로부터 dto 얻기
		MemberDto dto=memberService.getData(num);
		model.addAttribute("dto", dto);
		return "member/updateform";
	}	
	
	//수정후 디테일 페이지로 이동
	@PostMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto)
	{
		//수정
		memberService.updateMember(dto);
		return "redirect:./detail?num="+dto.getNum();
	}
	
	//{"status":"success" or "fail"}
	@ResponseBody
	@GetMapping("/member/delete")
	public Map<String, String> delete(@RequestParam int num,@RequestParam String passwd)
	{
		Map<String, String> map=new HashMap<String, String>();
		//비번이 맞을경우 데이타 삭제
		boolean b=memberService.isEqualPassCheck(num, passwd);
		if(b) {
			memberService.deleteMember(num);
		}
		map.put("status", b?"success":"fail");
		return map;
	}
}