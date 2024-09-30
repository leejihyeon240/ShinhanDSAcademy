package ch04.sec04;

public class PrintFrom1To1Example {

	public static void main(String[] args) {
		System.out.println("실행 흐름 시작");
		for (int i = 1; i <= 10; i++) {// 한 줄이면 중괄호 생략 가능, 하지만 가능하면 중괄호 사용하기
			if (i % 2 == 0)
				System.out.print(i + " ");
		}
		System.out.println("실행 흐름 끝");

		// 메소드 실행 순서 (안쪽부터 실행이 끝남)
		System.out.println(Integer.parseInt("3"));

		// for문 중첩
		// 구구단

		// 전체 구구단
		for (int j = 2; j <= 9; j++) {
			System.out.println(j + "단");
			for (int i = 1; i <= 9; i++) {
				System.out.println(j + " * " + i + " = " + i * j);
			}

		}
	}

}
