package chapter13;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
	List<StudentVO> list(StudentVO vo);
	int count(StudentVO vo);
	int insert(StudentVO vo);
//	int insertHobby(HobbyVO vo);
	StudentVO view(int studno);
	int idCheck(String id);
	StudentVO login(Map map);
}
