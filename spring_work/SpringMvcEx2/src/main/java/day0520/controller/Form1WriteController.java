package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1WriteController {
	@GetMapping("/read1")
	public String read1(
			//@RequestParam("name") String name,
			//@RequestParam String name,
			String name,	//@RequestParam도 생략 가능
			@RequestParam("addr") String a,	//formtag와다를때는 생략 안됨
			@RequestParam("age") int myage,
			Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("addr", a);
		model.addAttribute("age", myage);
		model.addAttribute("info", myage>=20?"성인":"미성년자");
		
		return "form1/result01";
	}
	
}
