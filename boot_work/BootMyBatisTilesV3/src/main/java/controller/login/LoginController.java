package controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import data.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	@ResponseBody
	@GetMapping("/member/login")
	public Map<String, String> isLogin(
			@RequestParam(defaultValue = "no") String saveid,/*널값이 넘어올경우 디폴트값이 적용된다*/
			@RequestParam String myid,
			@RequestParam String pass,
			HttpSession session)
	{
		System.out.println("saveid="+saveid);
		Map<String, String> map=new HashMap<>();
		//로그인 상태
		boolean loginStatus=memberService.isLoginCheck(myid, pass);
		if(loginStatus) {
			//아이디와 비번이 맞은경우
			map.put("status", "success");
			//로그인 성공시 세션에 저장
			session.setAttribute("saveid", saveid.equals("no")?"no":"yes");
			session.setAttribute("loginok", "yes");
			session.setAttribute("loginid", myid);
		}else {
			//아이디와 비번이 틀린경우
			map.put("status", "fail");
		}
		return map;
	}
	
	//로그아웃시 호출
	@ResponseBody
	@GetMapping("/member/logout")
	public void memberLogout(HttpSession session) {
		session.removeAttribute("loginok");
	}
	
}