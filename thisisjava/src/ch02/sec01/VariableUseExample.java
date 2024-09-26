package ch02.sec01;

public class VariableUseExample {

	static int number = 10; // 전체 허용

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour = 3;
		int minute = 5;
		String hour2 = "3";
		String minute2 = "5";
		System.out.println(hour2 + minute2); // 35

		System.out.println(3 + "하세요");
		System.out.println(hour + "시간" + minute + "분");

		int totalMinute = (hour * 60) + minute;
		System.out.println("총 " + totalMinute + "분");

		int var6 = 128;

		char aa = '안'; // 문자자료형(기본자료형)
		System.out.println(aa + 1);

		String aaa = "문자자료형"; // 참조자료형
		System.out.println(aaa.charAt(0));

		float f = 3.14f;
		double d = 3.14;

		boolean bb = true; // true, false 두개만 가능
		// 0: false 1: true
		System.out.println(bb);
		System.out.println(!bb);

		// int < double (정수는 실수보다 작음)
		int aaaa = 3;
		double bbbb = aaaa; // 자동형변환(허용 범위가 작은 타입이 허용 범위가 큰 타입으로 대입될 때 발생)
		System.out.println(bbbb);

		double cccc = 3.14;
		int dddd = (int) cccc; // 강제형변환
		System.out.println(dddd);

		// 문자열을 숫자로
		String eeee = "3";
		int ffff = Integer.parseInt(eeee); // 문자열을 정수로
		double gggg = Double.parseDouble(eeee); // 문자열을 실수로
		System.out.println(ffff * 3);
		System.out.println(gggg * 3);

		// 값을 문자로
		String hhhh = String.valueOf('A');

		// 숫자를 문자로
		String iiii = cccc + "";

		System.out.println(number);

		VariableUseExample.test();

	}

	public static void test() {
		System.out.println("테스트 함수 입니다.");
	}

}
