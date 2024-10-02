package ch05;

public class ObjectEquals {

	public static void main(String[] args) {
		// == 비교연산은 값 비교
		int a = 1; // 1이라는 리터럴 값
		String b = "1"; // "1"이라는 값이 저장 되어 있는 주소값

		int[] a1 = { 1, 2, 3 };
		int[] a2 = { 1, 2, 3 };
		System.out.println(a1.equals(a2));
		System.out.println(a1 == a2);
	}

}
