package ch06.sec04;

public class Student {
	String name; // 필드

	// 생성자
	Student(String n) {
		
		name = n;
		System.out.println();
		System.out.println();
	}

	// 기본 생성자(매개변수가 없는 생성자)
	// 생성자가 하나도 없으면 컴파일러가 자동 생성
	Student() {
		
	}
	
	// 메소드
	void Study() {
		String name = null; // 변수(지역변수)
		System.out.println(name);
	}
}
