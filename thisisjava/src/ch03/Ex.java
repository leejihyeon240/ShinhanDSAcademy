package ch03;

public class Ex {

	public static void main(String[] args) {
		// 부호
		int a = -10;
		int b = -a;
		System.out.println(b); // 10

		// 증감
		++b; // 전위
		b++; // 후위
		System.out.println(b); // 12

		System.out.println(b++); // 12, 실행문(출력)이 실행된 후 1 증가
		System.out.println(b); // 13

		System.out.println(5 / 3);
		System.out.println(5 / 3.0);
		
		// 비교연산
		System.out.println(1 < 2); // 무조건 결과 값이 boolean
		// 논리연산
		System.out.println(1 < 2 && 2 <= 3); // 무조건 결과 값이 boolean
	}

}
