package chapter08;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;
	
	@Override
	public List<StudentVO> list(StudentVO vo) {
		List<StudentVO> list = dao.list(vo);
		return list;
	}

}
