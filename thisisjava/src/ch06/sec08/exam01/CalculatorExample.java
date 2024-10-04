package ch06.sec08.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();

		myCalc.powerOn();

		int result1 = myCalc.plus(5, 6);
		System.out.println("result1 : " + result1);

		int x = 10;
		int y = 4;

		double result2 = myCalc.divide(x, y);
		System.out.println("result2 : " + result2);

		int result3 = myCalc.plus(5, 6, 5);
		System.out.println("result3 : " + result3);

		myCalc.powerOff();
	
		double result4 = myCalc.sum(1, 2, 5, 6, 5);
		System.out.println("result4 : " + result4);

	}

}
