package chapter02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		// xml 읽어들이기
		// 설정파일(xml)에 있는 bean(객체) 생성하고 container에 저장
//		ClassPathXmlApplicationContext ctx = 
//				new ClassPathXmlApplicationContext("chapter02/beans.xml");
		// 자바방식
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Beans.class);
		MemberService m = (MemberService)ctx.getBean("memberService");
		m.list();
	}

}









