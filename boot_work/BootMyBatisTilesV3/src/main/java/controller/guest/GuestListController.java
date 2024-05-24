package controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestListController {
	@GetMapping("/guest/list")
	public String list()
	{
		return "guest/guestlist";
	}
}