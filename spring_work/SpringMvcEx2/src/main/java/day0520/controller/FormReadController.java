package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormReadController {
	@GetMapping("/form1")
	public String form01() {
		return "form1/myform01";
	}
	
	@GetMapping("/form2")
	public String form2() {
		return "form2/myform02";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "form3/myform03";
	}
	
	@GetMapping("/form4")
	public String form4() {
		return "form4/myform04";
	}
	
	
}
