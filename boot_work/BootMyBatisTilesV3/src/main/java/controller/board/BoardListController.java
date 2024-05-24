package controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardListController {
	@GetMapping("/board/list")
	public String list()
	{
		return "board/boardlist";
	}
}