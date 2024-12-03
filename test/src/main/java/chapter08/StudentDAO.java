package chapter08;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<StudentVO> list(StudentVO vo) {
		return sst.selectList("student.list", vo);
	}
	
	public int count(StudentVO vo) {
		return sst.selectOne("student.count", vo);
	}
	
	public int insert(StudentVO vo) {
		return sst.insert("student.insert", vo);
	}
	public int insertHobby(HobbyVO vo) {
		return sst.insert("student.insertHobby", vo);
	}
}
