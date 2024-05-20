package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import day0520.dto.FoodDto;

@Controller
public class Form3WriteController {
	@PostMapping("/read3")
	public String read3(
			//formtag에서 같은 이름을 자동으로 읽음
			//model에 foodDto라는 이름으로 저장
			@ModelAttribute("fdto") FoodDto dto	
			) {
		
		return "form3/result03";
	}
}
