package chapter06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO dao;
	
	@Override
	public List<MemberVO> list(MemberVO vo) {
		
		return dao.list(vo);

	}

	@Override
	public MemberVO view(String id) {
		
		return dao.view(id);
	}

	@Override
	public boolean insert(MemberVO vo) {
		return dao.insert(vo) > 0 ? true : false;
	}

}
