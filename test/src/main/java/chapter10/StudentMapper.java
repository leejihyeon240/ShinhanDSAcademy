package chapter10;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
	List<StudentVO> list(StudentVO vo);
	int count(StudentVO vo);
	int insert(StudentVO vo);
	int insertHobby(HobbyVO vo);
}
