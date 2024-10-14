package ch12;

public class MathEx {

	public static void main(String[] args) {
		double d = 3.141592;

		// 소수점 5자리에서 반올림
		double e = (double) Math.round(d * 10000) / 10000;
		System.out.println(e);

		// 소수점 3자리로 반올림

	}

}
