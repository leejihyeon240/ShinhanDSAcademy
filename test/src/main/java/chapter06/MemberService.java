package chapter06;

import java.util.List;

public interface MemberService {
	List<MemberVO> list();
	MemberVO view(String id);
}
