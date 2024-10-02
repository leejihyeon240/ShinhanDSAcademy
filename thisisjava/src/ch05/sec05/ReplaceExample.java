package ch05.sec05;

public class ReplaceExample {

	public static void main(String[] args) {
		String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
		String newStr = oldStr.replace("자바", "JAVA");

		System.out.println(oldStr);
		System.out.println(newStr);
		System.out.println(oldStr.substring(8)); // 인덱스 8~13

		System.out.println("abcd".substring(2, 3));
		
		// 불변(immutable)
		// 문자열은 특정 위치(범위) 변경 불가
		// oldStr[0] = "";

		// mutable
		int[] a = { 1, 2, 3, 4, 5 };
		a[0] = 6; // 변경

	}

}
