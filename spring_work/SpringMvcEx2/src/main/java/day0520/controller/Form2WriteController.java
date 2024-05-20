package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Form2WriteController {
	@PostMapping("/read2")
	//formtag와 같은 변수로 읽어 올 경우 request생략
	public String read2(String name, String addr, int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		model.addAttribute("age", age);
		
		return "form2/result02";
	}
}
