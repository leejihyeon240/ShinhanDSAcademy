package ch06;

public class Main {

	public static void main(String[] args) {
		// 객체 생성
		Person cheolsu = new Person(); // new 생성자 -> 객체 생성
		Person youngsu = new Person(); // new 생성자 -> 객체 생성

		// 철수 == 영수
		cheolsu.name = "철수";
		youngsu.name = "철수";
		System.out.println(cheolsu == youngsu); // 메모리 주소값이 다르므로

		// 영수의 이름을 영수로 변경
		youngsu.name = "영수";
		System.out.println(youngsu.name);
		System.out.println(cheolsu.name);

		youngsu = new Person();

		cheolsu = new Person("철수", 20);
		youngsu = new Person("영수", 20);
		System.out.println(cheolsu.name + "," + cheolsu.age);

		// 메서드 실행(호출, call)
		youngsu.study();
		cheolsu.study("영어");

		System.out.println(cheolsu.toString());
		System.out.println(youngsu);

		String a = cheolsu.toString();
		int b = cheolsu.plus(10);
		System.out.println(b);

		// static 메서드(정적, 공유, 클래스로 접근)
		int c = Person.minus(10); // 클래스로 직접 접근(객체 생성 불필요)
		System.out.println(c);

		Person.job = "학생";
		System.out.println(youngsu.job);
		System.out.println(cheolsu.job);
		
		// 같은 패키지(또는 java.lang)는 import 필요 없음
		// 자동 import 단축기는 ctrl+shift+o
		ch06.sec08.exam03.Car d = new ch06.sec08.exam03.Car();
		System.out.println(d.getClass().getName());
		
	}

}
