package ch06;

import java.util.Scanner;

public class BankApplication {

	private static Scanner scanner = new Scanner(System.in);

	private static Account[] accountArray = new Account[100];

	public static void main(String[] args) {

		while (true) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("------------------------------------------------");
			System.out.print("선택> ");

			String number = scanner.nextLine();

			if ("1".equals(number)) {
				System.out.println("------------------------------------------------");
				System.out.println("계좌생성");
				System.out.println("------------------------------------------------");
				
				System.out.print("계좌번호: ");
				String account = scanner.nextLine();
				
				System.out.print("계좌주: ");
				String name = scanner.nextLine();

				System.out.print("초기입금액: ");
				int money = scanner.nextInt();
				scanner.nextLine();

				Account newAccount = new Account(account, name, money);

				for (int i = 0; i < accountArray.length; i++) {
					if (accountArray[i] == null) {
						accountArray[i] = newAccount;
						break; // break를 해주지 않으면 계좌 100개 생김
					}
				}

				System.out.println("결과: 계좌가 생성되었습니다.");

			} else if ("2".equals(number)) {
				System.out.println("------------------------------------------------");
				System.out.println("계좌목록");
				System.out.println("------------------------------------------------");

				for (int i = 0; i < accountArray.length; i++) {
					Account account = accountArray[i];
					if (accountArray[i] != null) {
						System.out.println(account.toString());
					}
				}
			} else if ("3".equals(number)) {
				System.out.println("------------------------------------------------");
				System.out.println("예금");
				System.out.println("------------------------------------------------");

				System.out.print("계좌번호: ");
				String account = scanner.nextLine();

				System.out.print("예금액: ");
				int money = scanner.nextInt();
				scanner.nextLine();

				Account findAcc = findAccount(account);

				findAcc.setMoney(findAcc.getMoney() + money);
				System.out.println("결과: 예금이 성공되었습니다.");

			} else if ("4".equals(number)) {
				System.out.println("------------------------------------------------");
				System.out.println("출금");
				System.out.println("------------------------------------------------");

				System.out.print("계좌번호: ");
				String account = scanner.nextLine();

				System.out.print("출금액: ");
				int money = scanner.nextInt();
				scanner.nextLine();

				Account findAcc = findAccount(account);

				findAcc.setMoney(findAcc.getMoney() - money);
				System.out.println("결과: 출금이 성공되었습니다.");

			} else if ("5".equals(number)) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

	static Account findAccount(String account) {
		Account findAcc = null;

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				String accountNum = accountArray[i].getAccount();
				if (accountNum.equals(account)) {
					findAcc = accountArray[i];
//					break;
				}
			}
		}
		return findAcc;
	}

}
