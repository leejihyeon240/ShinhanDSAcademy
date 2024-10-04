package ch05;

import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] scores = null;
		int studentNum = 0;

		while (true) {
			System.out.println("----------------");
			System.out.println("1. 학생 수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
			System.out.println("----------------");
			System.out.print("선택> ");

			String number = scanner.nextLine();

			if ("1".equals(number)) {
				System.out.print("학생수> ");
				studentNum = scanner.nextInt();
				scores = new int[studentNum];
			} else if ("2".equals(number)) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]>");
					scores[i] = scanner.nextInt();
				}
			} else if ("3".equals(number)) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]: " + scores[i]);
				}
			} else if ("4".equals(number)) {
				int max = 0;
				int sum = 0;

				for (int i = 0; i < scores.length; i++) {
					if (scores[i] > max) {
						max = scores[i];
					} else {
						max = max;
					}
					sum += scores[i];
				}

				double average = (double) sum / studentNum;

				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + average);

			} else if ("5".equals(number)) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
