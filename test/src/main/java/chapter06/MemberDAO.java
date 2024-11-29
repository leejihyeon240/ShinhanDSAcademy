package chapter06;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	// SqlSessionTemplate 주입
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<MemberVO> list() {
		List<MemberVO> list = sst.selectList("member.memberList");
		return list;
	}
	public MemberVO view(String id) {
		return sst.selectOne("member.memberOne", id);
	}
}
