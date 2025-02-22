package chapter08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;

	@Override
	public Map<String, Object> list(StudentVO vo) {
		List<StudentVO> list = dao.list(vo);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", dao.count(vo));
		return map;
	}

	@Override
	public void insert(StudentVO vo) {
		System.out.println(vo); // 파라미터만 담기 vo
		dao.insert(vo); // 등록
		System.out.println(vo); // 파라미터가 담기 vo + PK(studno)추가

		// 취미 등록
		for (String hobby : vo.getHobbyName()) {
			HobbyVO hvo = new HobbyVO();
			hvo.setStudno(vo.getStudno());
			hvo.setName(hobby);
			dao.insertHobby(hvo);
		}
	}

}
