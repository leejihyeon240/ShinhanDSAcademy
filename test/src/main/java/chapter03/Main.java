package chapter03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Beans.class);
		BoardController c = (BoardController)ctx.getBean("boardController");
		c.list();
	}

}
