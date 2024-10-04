package ch06.sec08.exam01;

public class Calculator {
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	int plus(int x, int y) {
		int result = x + y;
		return result;
	}

	// 오버로딩
	int plus(int x, int y, int z) {
		int result = x + y + z;
		return result;
	}

	double divide(int x, int y) {
		double result = (double) x / (double) y;
		return result;
	}

	int sum(int... values) {
		int sum = 0;

		for (int i = 0; i < values.length; i++) {
			sum += values[i];

		}
		return sum;
	}
}
