package ch07;

public class Main {

	public static void main(String[] args) {
		// 자식객체
		Child c = new Child(); // Child() 생성자에서 부모(Parent)생성자도 실행
		c.x(); // Parent 상속 받은 메서드
		c.y();

		Parent p = c; // 자동형변환 Child -> Parent
		Object o = c; // 자동형변환 Child -> Parent

		Parent p2 = new Parent();
		// p2.y(); 사용불가
		// p.y(); 사용불가

		// 강제형변환 (값이 자식타입이었다가 부모타입으로 변환된 경우)
		// Child c2 = (Child)p2; 사용불가

	}

}
