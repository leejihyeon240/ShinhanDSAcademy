package chapter06;

import java.util.List;

public interface MemberService {
	List<MemberVO> list(MemberVO vo);
	MemberVO view(String id);
	boolean insert(MemberVO vo);
}
