package ch06;

import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Account[] accountArray = new Account [100];

		while (true) {
			System.out.println("----------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("----------------");
			System.out.print("선택> ");

			String number = scanner.nextLine();

			if ("1".equals(number)) {
				System.out.println("----------------");
				System.out.print("계좌생성");
				System.out.println("----------------");

				String account = scanner.nextLine();
				System.out.print("계좌번호: "+ account);
				
				String name = scanner.nextLine();
				System.out.print("계좌주: "+ name);
				
				int initMoney = scanner.nextInt();
				System.out.print("초기입금액: "+ initMoney);
				
				Account newAccount = new Account(account, name, initMoney);
				
				for(int i = 0; i < accountArray.length; i++) {
					if(accountArray[i] == null) {
						accountArray[i] = newAccount;
//						break;
					}
				}
					
				System.out.print("결과: 계좌가 생성되었습니다.");
				
			} else if ("2".equals(number)) {
				System.out.println("----------------");
				System.out.print("계좌목록");
				System.out.println("----------------");
				
				for (int i = 0; i < accountArray.length; i++) {
					Account account = accountArray[i];
					if(accountArray[i] != null) {
						System.out.println(account.toString());
					}
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
}
