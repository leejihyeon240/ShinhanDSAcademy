package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardServiceImpl2") // 빈이름 지정
	BoardService service; // BoardService의 자식/구현클래스 타입 가능
	
	public void list() {
		service.list();
	}
}
