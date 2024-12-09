package chapter13;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = {"API 테스트 컨트롤러"})
//@CrossOrigin({"http://127.0.0.1:5500"})
@CrossOrigin({"*"})
@RestController
//@RequestMapping("/api")
public class ApiController {
	@ApiOperation("테스트")
	@GetMapping("/api/test")
	public String test() {
		return "test";
	}
	
	@PostMapping("/api/test2")
	public String test2() {
		return "test2";
	}
	
	// 객체로 리턴
	@ApiOperation(value="테스트", notes="설명")
	@GetMapping("/api/test3")
	public StudentVO test3(StudentVO vo) {
//		StudentVO vo = new StudentVO();
		return vo;
	}
	
	// 배열(리스트)로 리턴
	@GetMapping("/api/test4")
	public List test4(StudentVO vo) {
		List<StudentVO> list = new ArrayList<>();
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		return list;
	}
	
	// 파라미터 받는 방법(JSON 데이터)
	@PutMapping("/api/test5")
	public Map test5(@RequestBody StudentVO vo) {
		System.out.println(vo);
		Map<String, Object> map = new HashMap<>();
		map.put("data", vo);
		map.put("result", 5);
		map.put("date", new Date());
		return map;
	}
	
	// 응답코드 응답
	@GetMapping("/api/test6")
	public ResponseEntity<StudentVO> test6(StudentVO vo) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vo);
	}
	
	// DB연동
	@Autowired
	private StudentMapper mapper;
	// id 중복 체크
	@GetMapping("/api/student/idCheck/{id}")
	public boolean idCheck(@ApiParam("학생아이디") @PathVariable String id) {
		return mapper.idCheck(id) > 0 ? true : false;
	}
	// 목록(총개수, 리스트)
	@GetMapping("/api/student/list")
	public Map list(StudentVO vo) {
		Map<String, Object> map = new HashMap<>();
		map.put("count",mapper.count(vo));
		map.put("list", mapper.list(vo));
		return map;
	}
	
}
