package chapter10;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping({"/student/index.do", "/student"})
	public String index(Model model, StudentVO vo) {
		System.out.println(Arrays.toString(vo.getSearchMajor()));
		model.addAttribute("map", service.list(vo));
		return "student/index";
	}
	
	@GetMapping("/student/write.do")
	public void write() {
		System.out.println("write");
	}
	@PostMapping("/student/regist.do")
	public String regist(Model model, StudentVO vo) {
		service.insert(vo);
		model.addAttribute("msg", "등록 완료");
		model.addAttribute("url", "index.do");
		return "common/alert";
	}
}
