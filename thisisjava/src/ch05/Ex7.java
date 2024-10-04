package ch05;

public class Ex7 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 3, 8, 2 };

		// 최대값
		// int max = array[0];
		int max = Integer.MIN_VALUE;

		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		System.out.println("최대값: " + max);

		// 최소값
		// int min = array[0];

		int min = Integer.MAX_VALUE;

		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}

		System.out.println("최소값: " + min);
	}
}
