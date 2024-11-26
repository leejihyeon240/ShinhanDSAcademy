package chapter01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJava {

	public static void main(String[] args) {
		// 설정파일 읽어들이고, 빈 생성, 컨테이너 저장
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Beans.class); 
		Person p = (Person)ctx.getBean("person");
		Person p2 = ctx.getBean("person", Person.class);
		System.out.println(p == p2);
		
		System.out.println(ctx.getBean("person3"));
	}

}
