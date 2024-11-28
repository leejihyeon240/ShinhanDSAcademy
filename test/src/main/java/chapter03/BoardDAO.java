package chapter03;

import org.springframework.stereotype.Repository;

// 자동으로 빈생성 저장 (id:boardDAO)
//@Component
@Repository
public class BoardDAO {
	void list() {
		System.out.println("게시판 목록");
	}
}
