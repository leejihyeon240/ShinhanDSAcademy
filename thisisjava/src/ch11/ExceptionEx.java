package ch11;

public class ExceptionEx {

	public static void main(String[] args) {
		System.out.println("시작");

		int a = 10;
		int b = 0;
		int[] arr = { 1, 2, 3 };

		try {
			// 예외 발생 가능 코드
			int c = a / b;
			arr[3] = 0;
		} catch (ArithmeticException e) {
			// 예외가 발생하면 실행되는 코드
			System.out.println("예외 발생");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생2");
		}

		System.out.println("끝");
	}

}
