package chapter13;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@PostMapping("/test2")
	public String test2() {
		return "test2";
	}

	// 객체로 리턴
	@GetMapping("/test3")
	public StudentVO test3(StudentVO vo) {
//		StudentVO vo = new StudentVO();
		return vo;
	}

	// 배열(리스트)로 리턴
	@GetMapping("/test4")
	public List test4(StudentVO vo) {
		List<StudentVO> list = new ArrayList<>();
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		return list;
	}

	// 파마리터 받는 방법(JSON 데이터)
	@PutMapping("/test5")
	public Map test5(@RequestBody StudentVO vo) {
		System.out.println(vo);
		Map<String, Object> map = new HashMap<>();
		map.put("data", vo);
		map.put("result", 200);
		map.put("date", new Date());
		return map;
	}

	// 응답코드 응답
	@GetMapping("/test6")
	public ResponseEntity<StudentVO> test6(StudentVO vo) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vo);
	}

	// DB 연동
	@Autowired
	private StudentMapper mapper;

	// id 중복 체크
	@GetMapping("/student/idCheck/{id}")
	public boolean idCheck(@PathVariable String id) {
		return mapper.idCheck(id) > 0 ? true : false;
	}

	// 목록(총 개수, 리스트)
	@GetMapping("/student/list")
	public Map list(StudentVO vo) {
		Map<String, Object> map = new HashMap<>();
		map.put("count", mapper.count(vo));
		map.put("list", mapper.list(vo));
		return map;
	}
}
