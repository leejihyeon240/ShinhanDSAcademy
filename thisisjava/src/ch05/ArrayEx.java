package ch05;

import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
		// 배열 선언
		int[] a;
		int b[];

		// 초기화
		a = new int[] { 1, 2, 3, 4, 5 }; // 요소(1,2,3,4,5)가 있는 배열 객체 생성
		b = new int[3]; // 길이가 3인 배열 객체 생성 (요소들이 0으로 초기화)

		// 접근(인덱싱)
		// a 변수의 두번째 값 접근
		// a[두번째 인덱스]
		System.out.println(a[1]);
		// 값 변경
		a[1] = 6; // 1번 인덱스에 6 대입
		System.out.println(a[1]);

		// 배열 전체 요소 출력
		// for (int i = 0; i<변수.length; i++)
		for (int i = 0; i <= 4; i++) {
			System.out.println(a[i]);
		}

		System.out.println(Arrays.toString(a));

		System.out.println("배열의 길이: " + a.length);

		// 선언과 동시에 초기화
		int[] c = new int[5];
		int[] d = { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(c));

		// c에 있는 요소의 값을 변경
		for (int i = 0; i < c.length; i++) {
			c[i] = i + 1;

		}

		System.out.println(Arrays.toString(c));

		// 참조 자료형 특징
		int a1 = 1;
		int b1 = a1;
		System.out.println(b1);

		b1 = 2;
		System.out.println(a1);

		int[] a2 = { 1, 2, 3 };
		int[] b2 = a2;
		System.out.println(Arrays.toString(b2));
		b2[0] = 4; // 같은 곳을 가리키고 있기 때문에 바뀜
		System.out.println(Arrays.toString(a2));
		int[] a3 = { 1, 2, 3 };
		System.out.println(a2 == a3); // 다른 주소
		System.out.println(a2 == b2); // 같은 주소

		// 참조자료형은 null로 초기화 가능
		String[] a4 = new String[3];
		System.out.println(Arrays.toString(a4));

		// 객체가 null인 상태에서 접근(.)
		System.out.println(a4.length);
	}

}
