package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BoardServiceImpl implements BoardService {
	
	// 자동주입 (같은 타입)
	@Autowired
	private BoardDAO dao;

	@Override
	public void list() {
		dao.list();
	}

}
