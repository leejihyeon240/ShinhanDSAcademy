package chapter07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/index2.do")
	public String index(Model model) {
		model.addAttribute("list", service.list());
		return "member/index2";
	}
}
