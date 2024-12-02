package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/member/index.do")
	public String index(Model model, MemberVO param) {
		model.addAttribute("list", service.list(param));
		return "member/index";
	}

	@GetMapping("/member/view.do")
	public String view(Model model, @RequestParam String id) {
		model.addAttribute("member", service.view(id));
		return "member/view";
	}

	// 등록폼
	@GetMapping("/member/regist.do")
	public String write() {
		return "member/write";
	}

	// 등록처리
	// 사용자가 입력한(id,pwd,name,email) 저장 후 '정상적으로 가입되었습니다.' or '가입 오류' 목록 이동
	@PostMapping("/member/regist.do")
//	public void regist(MemberVO param, HttpServletResponse res) throws ServletException, IOException{
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.print("<script>");
//		if (service.insert(param)) {
//			out.print("alert('정상적으로 가입되었습니다.');");
//		} else {
//			out.print("alert('가입오류');");
//		}
//		out.print("location.href='index.do';");
//		out.print("</script>");
//	}
	// 응답을 공통 jsp로
	public String regist(MemberVO param, HttpServletResponse res, Model model) throws ServletException, IOException {
		String msg = "";
		String url = "";
		if (service.insert(param)) {
			msg = "정상적으로 가입되었습니다.";
			url = "index.do";
		} else {
			msg = "가입오류";
			url = "regist.do";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "common/alert";
	}
}
