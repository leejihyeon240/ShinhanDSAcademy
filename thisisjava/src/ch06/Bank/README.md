### 문제 설명
![](https://velog.velcdn.com/images/leejihyeon240/post/027b390f-e27c-46c9-a575-24c59a084dff/image.png)

***
Account.java
```
package ch06;

public class Account {
	
	private String account;
	private String name;
	private int money;
	
	public Account(String account, String name, int money) {
		this.account = account;
		this.name = name;
		this.money = money;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
	    return account + "   " + name + "   " + money;
	}
	
}
```

BankApplication.java
```
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
```

### 출력
![](https://velog.velcdn.com/images/leejihyeon240/post/34107277-af72-41d8-a04d-b459ffe1597b/image.png)

***

### 고민했던 부분
#### 1. break

```
for (int i = 0; i < accountArray.length; i++) {
					if (accountArray[i] == null) {
						accountArray[i] = newAccount;
						break;
					}
				}

```
break를 해주지 않았을 때 계좌가 100개가 생겼다.
break를 if문에서 잘 사용 안 했던 거 같은데, 중요성을 깨달았다.

#### 2. toString() 재정의

```
@Override
	public String toString() {
	    return account + "   " + name + "   " + money;
	}
```

toString()을 재정의 해주지 않아서 계좌 목록을 조회 했을 때
ch06.Account@1888ff2c 라고 나왔다.

그래서 Account에서 toString()을 재정의 하였다.
그러니 원하는 결과인

111-111   김운학   60000
111-222   우지호   15000

로 잘 나왔다.

#### 3. 연속 출력

![](https://velog.velcdn.com/images/leejihyeon240/post/52adb24e-9810-443f-b0ff-b0da416b80ef/image.png)

안내 문구(?)가 연속으로 출력되는 현상이 있었다.

이유는 scanner.nextInt() 이후에 입력 버퍼에 남아 있는 줄바꿈 문자를 처리하지 않았기 때문이었다. 

이 문제를 해결하려면 scanner.nextInt() 뒤에 scanner.nextLine()을 추가해서 버퍼를 비워주면 된다.

### 개념 정리

- getter() 메서드
getter 메서드는 설정한 변수 값을 읽어오는 데 사용한다. 경우에 따라 객체 외부에서 필드 값을 사용하기에 부적절한 경우가 발생할 수 있는데, 이러한 경우에는 값을 가공한 이후에 외부로 전달하는 역할을 한다.
 
- setter() 메서드
setter 메서드는 외부에서 메서드에 접근하여 조건에 맞을 경우 데이터 값을 변경할 수 있도록 한다.

- public 모든 접근을 허용
- protected 같은 패키지(폴더)에 있는 객체와 상속관계의 객체들만 허용
- default 같은 패키지(폴더)에 있는 객체들만 허용
- private 현재 객체 내에서만 허용

### 마무리
![](https://velog.velcdn.com/images/leejihyeon240/post/8fe38abb-0dd2-4b85-9e6b-ab5c3a361caa/image.png)

이 부분이 어려워서 구글링 참고를 했다.

그리고 코드를 다음부터는 예쁘게 함수별로 다 분리하도록 해야겠다!
