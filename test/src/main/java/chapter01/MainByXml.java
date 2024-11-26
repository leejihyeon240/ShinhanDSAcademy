package chapter01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		// 기존
//		Person p = new Person();
		
		// xml 읽어들이기
		// 설정파일(xml)에 있는 bean(객체) 생성하고 container에 저장
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("chapter01/beans.xml");
		Person p = (Person)ctx.getBean("person");
		System.out.println(p);
		
		// 싱글톤
		Person p2 = (Person)ctx.getBean("person");
		System.out.println(p == p2);
		
		// id가 person인 객체를 Person.class 타입으로 리턴
		Person p3 = ctx.getBean("person", Person.class);
		System.out.println(p == p3);
		
		// person2
		Person person2 = ctx.getBean("person2", Person.class);
		System.out.println(person2);
		
	}

}









