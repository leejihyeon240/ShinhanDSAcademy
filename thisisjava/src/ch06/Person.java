package ch06;

public class Person {

	// 필드(속성)
	String name; // 인스턴스 필드
	int age; // 인스턴스 필드
	static String job; // static 필드
	final String school = "신한 대학교"; // final 읽기만 허용(한번 초기화되면 변경 불가)

	// 생성자
	// 오버로딩 : 이름은 같지만 매개변수의 타입/개수/(순서) 중 하나가 다르면 오버로딩

	Person() { // 기본 생성자

	}

	Person(String name) {

	}

	Person(int age) {

	}

	Person(String name, int age) {
		// this : 객체 자신
		this.name = name;
		this.age = age;
	}

	// 메서드(기능)
	// 접근제한자 [static] 리턴타입 메서드명([매개변수...,])
	void study() { // 인스턴스 메서드
		System.out.println(this.name + "가 공부하다");
	}

	void study(String subject) { // 인스턴스 메서드
		System.out.println(subject + "를 공부하다");
	}

	void sleep() { // 인스턴스 메서드
		System.out.println("자다");
	}

	// 재정의(오버라이딩)
	public String toString() {
		return "Person {name: " + this.name + ", age:" + this.age + "}";
	}

	int plus(int x) {
		return x + 1;
	}

	static int minus(int x) {
		return x - 1;
	}
}