package ch04.sec07;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int accout = 0;

		while (true) {
			System.out.println("----------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------");
			System.out.print("선택> ");
			String number = scanner.nextLine();

			if ("1".equals(number)) { // NULL 방지 에러 방지
				System.out.print("예금액> ");
				String money = scanner.nextLine();
				accout += Integer.parseInt(money);
			} else if ("2".equals(number)) {
				System.out.print("출금액> ");
				String money = scanner.nextLine();
				accout -= Integer.parseInt(money);
			} else if ("3".equals(number)) {
				System.out.println("잔고> " + accout);
			} else if ("4".equals(number)) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
