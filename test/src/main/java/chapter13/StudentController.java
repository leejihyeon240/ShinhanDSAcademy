package chapter13;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;

	@GetMapping({"/student/index.do", "/student"})
	public String index(Model model, StudentVO vo) {
		System.out.println(Arrays.toString(vo.getSearchMajor()));
		model.addAttribute("map", service.list(vo));
		return "student/index2";
	}
}
