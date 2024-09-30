package ch04.sec07;

public class Ex3 {

	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i <= 99; i++) {
			if (i % 3 == 0) {

				sum += i;
			}

		}
		System.out.println(sum);

	}

}
