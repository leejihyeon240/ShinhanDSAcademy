package chapter02;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO dao;
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}

	@Override
	public void list() {
		// MemberDAO 객체의 listMembers()메서드 호출
		dao.listMembers();
	}

}
