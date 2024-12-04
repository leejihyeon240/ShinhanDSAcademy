package chapter12;

import java.io.File;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	public String regist(Model model, StudentVO vo, @RequestParam MultipartFile filename, HttpServletRequest req) {
		if (!filename.isEmpty()) { // 사용자가 파일을 첨부했으면
			try {
				// 파일명 변경
				String org_filename = filename.getOriginalFilename(); // 원본파일명
				String real_filename = System.currentTimeMillis()+org_filename.substring(org_filename.lastIndexOf("."));
				// 파일을 /upload경로에 저장
				//
				File file = new File(req.getRealPath("/upload/")+real_filename);
				filename.transferTo(file);
				// vo에 파일명 저장
				vo.setReal_filename(real_filename);
				vo.setOrg_filename(org_filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		service.insert(vo);
		model.addAttribute("msg", "등록 완료");
		model.addAttribute("url", "index.do");
		return "common/alert";
	}
	
	@GetMapping("/student/view.do")
	public String view(@RequestParam int studno, Model model) {
		model.addAttribute("vo", service.view(studno));
		return "student/view";
	}
	
	@GetMapping("/student/idCheck.do")
	@ResponseBody
	public boolean idCheck(@RequestParam String id) {
		return service.idCheck(id);
	}
}
