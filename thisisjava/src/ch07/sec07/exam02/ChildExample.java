package ch07.sec07.exam02;

public class ChildExample {

	public static void main(String[] args) {

		// 자식 객체 생성
		Child child = new Child();

		// 자동 타입 변환
		Parent parent = child;

		parent.method1();
		parent.method2();
//		parent.method3(); 호출 불가능

		System.out.println("------------------");
		
		Parent[] parr = { parent, new Parent(), child, new Child(), new Child() }; // 다형성, Child가 Parent를 상속 받기 때문에

		Object[] arr = { "", 1, 3.14, 'A', parent }; // Object가 상위 클래스이기 때문에

		for (Parent p : parr) {
			p.method2();
		}
	}

}
