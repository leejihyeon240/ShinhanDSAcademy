package chapter05.execute;

public class CalculatorImpl2 implements Calculator {

	@Override
	public long factorial(int num) {
		if (num == 0) {
			return 1;
		}
		
		// 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
		return num * factorial(num - 1);
	}

}
