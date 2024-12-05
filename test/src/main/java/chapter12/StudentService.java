package chapter12;

import java.util.Map;

public interface StudentService {
	Map<String, Object> list(StudentVO vo);
	void insert(StudentVO vo);
	StudentVO view(int studno);
	boolean idCheck(String id);
	StudentVO login(Map map);
}
