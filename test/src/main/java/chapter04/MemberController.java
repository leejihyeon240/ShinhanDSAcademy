package chapter04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user") // 내부 메서드의 모든 URL앞에 포함
public class MemberController {
	// GET방식으로 /test.do -> /WEB-INF/views/test.jsp 포워딩
	@GetMapping("/test.do")
	public String test() {
		System.out.println("test");
		return "a/test";
	}
	
	@GetMapping("/test2.do")
	public String test2() {
		System.out.println("test2");
		return "test";
	}
	
	@PostMapping("/test3.do")
	public String test3() {
		return "";
	}
	// get, post... 모든 method 가능
	// 만약 특정 method만 가능하게하려면 method 속성 사용
	@RequestMapping(value="/test4.do", method=RequestMethod.POST)
	public String test4() {
		return "test";
	}
	
	
	
	// 응답
	// String -> prefix + 문자열 + suffix 포워딩
	// void -> prefix + 접속url + suffix 포워딩
	@GetMapping("/home.do") // url : /user/home.do -> /WEB-INF/views/user/home.jsp
	public void home() {
		
	}
	
	// 리다이렉트
	// /user/test5.do -> /user/test.do
	@GetMapping("/test5.do")
	public String test5() {
//		return "redirect:/user/test.do"; // 절대경로(컨텍스트패스X)
//		return "redirect:test.do"; // 상대경로
		return "redirect: /test/user/test.do"; // 절대경로(컨텍스트패스O)
	}
	
	// 파라미터 받는 방법
	// 1. HttpServletRequest
	@GetMapping("/test6.do")
	public void test6(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println("id:"+id);
	}
	// 2. @RequestParam : 파라미터의 해당 매개변수명의 값을 변수에 저장, 전달
	@GetMapping("/test7.do")
	public void test7(@RequestParam(value="idx", required = false) String id,
						@RequestParam(required = false, defaultValue = "0") int age) {
		System.out.println("id:"+id);
		System.out.println("age:"+age);
		String idx;
	}
	// 3. @ModelAttribute
	@GetMapping({"/member/form.do","/member/form2.do"})
	public String memberForm() {
		System.out.println("/member/form.do");
		return "member/form";
	}
	@PostMapping("/member/regist.do")
	public void memberRegist(@ModelAttribute MemberVO vo,
								@RequestParam Map<String, Object> map,
								HttpServletRequest request,
								HttpServletResponse response) throws ServletException, IOException{
		System.out.println("/member/regist.do");
		System.out.println(vo);
		System.out.println(map);
		request.setAttribute("map", map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('정상적으로 가입되었습니다.');location.href='form.do';");
		out.print("</script>");
//		return "member/form";
	}
	
	// 4. @PathVariable
	@GetMapping("/member/{id}")
	public void path(@PathVariable String id) {
		System.out.println("id:"+id);
	}
	
	// Model
	// 포워딩되는 jsp에서 사용하기 위해
	// test8.do?v=3 -> 9출력 
	@GetMapping("/test8.do")
	public ModelAndView test8(@RequestParam int v, 
							Model model, 
							HttpSession sess,
							HttpServletRequest req) {
		int v2 = v * v;
		model.addAttribute("v3", v2); // request
		sess.setAttribute("v4", v2);
		
		ModelAndView mav = new ModelAndView("test8");
		mav.addObject("v5", v2); // request
		
		req.setAttribute("v6", v2); // request
		
		return mav;
	}
	
	@GetMapping("/test9.do")
	@ResponseBody
	public Map test9() {
		
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("gildong");
		
		MemberVO[] arr = {vo, vo, vo};
		
		Map<String, Object> map = new HashMap<>();
		map.put("page", 1);
		map.put("searchWord", "java");
		map.put("list", arr);
		
		return map;
	}
	
	
	
}