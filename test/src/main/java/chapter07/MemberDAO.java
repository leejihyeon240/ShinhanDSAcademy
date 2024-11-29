package chapter07;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	// SqlSessionTemplate
	@Autowired
	private SqlSessionTemplate sst;

	public List<MemberVO> list() {
		List<MemberVO> list = sst.selectList("member.memberList");
		return list;
	}
}
