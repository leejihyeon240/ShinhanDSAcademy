package chapter08;

import java.util.Map;

public interface StudentService {
	Map<String, Object> list(StudentVO vo);
	void insert(StudentVO vo);
}
