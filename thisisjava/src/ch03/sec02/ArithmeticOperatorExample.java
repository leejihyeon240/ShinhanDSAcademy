package ch03.sec02;

public class ArithmeticOperatorExample {

	public static void main(String[] args) {

		byte v1 = 10;
		byte v2 = 4;
		int v3 = 5;
		long v4 = 10L;

		int result1 = v1 + v2;
		System.out.println("result1: " + result1);

		long result2 = v1 + v2 - v4;
		System.out.println("result2: " + result2);

		double result3 = (double) v1 / v2;
		System.out.println("result3: " + result3);

		int result4 = v1 % v2;
		System.out.println("result4: " + result4);

		int math1 = 90;
		int math2 = 95;
		int math3 = 92;
		// 자바는 int끼리 더해서 나누면 결과가 int가 나오기 때문에, 소수점까지 받으려면 double로 바꿔야 함.
		double total = math1 + math2 + math3;
		double avg = total / 3; // 아니면 3.0을 하던가
		System.out.println(avg);

	}

}
