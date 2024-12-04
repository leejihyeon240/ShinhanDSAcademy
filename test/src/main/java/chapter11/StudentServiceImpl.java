package chapter11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
//	private StudentDAO dao;
	private StudentMapper mapper;

	@Override
	public Map<String, Object> list(StudentVO vo) {
		System.out.println("================");
		System.out.println(mapper.getClass().getName());
		List<StudentVO> list = mapper.list(vo);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", mapper.count(vo));
		return map;
	}

	@Override
	@Transactional
	public void insert(StudentVO vo) {
		System.out.println(vo); // 파라미터만 담기 vo
		mapper.insert(vo); // 등록
		System.out.println(vo); // 파라미터가 담기 vo + PK(studno)추가

		// 취미 등록
		for (String hobby : vo.getHobbyName()){
			HobbyVO hvo = new HobbyVO();
			hvo.setStudno(vo.getStudno());
			hvo.setName(hobby);
			mapper.insertHobby(hvo);
		}
	}
	
	@Override
	public StudentVO view(int studno) {
		return mapper.view(studno);
	}

}
