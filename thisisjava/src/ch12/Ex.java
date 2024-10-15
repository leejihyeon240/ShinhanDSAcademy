package ch12;

public class Ex {

	public static void main(String[] args) {
		// 문자열을 정수로
		String a = "1";
		int b = Integer.parseInt(a);
		System.out.println(a + 1);
		
		// 정수를 문자열로
		String cb = b + ""; // "" 문자열을 붙여주면 자동으로 바뀜
		String c = String.valueOf(true); // valueOf : 기본 자료형을 문자형으로 바꿈
		System.out.println(c);
		
		long d = b;
		Object e = b; // int -> Integer -> Object
		Integer f = 1; // int -> Integer(auto-boxing) [기본 자료형이 클래스로 바뀐 것]
		int h = f; // Integer -> int (unboxing)
		Object g = f; // Integer -> Object (자동형변환)
	}

}
