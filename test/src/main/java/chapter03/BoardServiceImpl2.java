package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardServiceImpl2 implements BoardService {
	
	// 자동주입 (같은 타입)
	@Autowired
	private BoardDAO dao;

	@Override
	public void list() {
		System.out.println("Impl2");
		dao.list();
	}

}
