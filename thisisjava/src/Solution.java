
public class Solution {
	public int solution(int m, int[] ledger) {

		// 초기 잔액 0원
		int account = 0;

		int input = m;
		System.out.println(m);
//		
//		String values = ledger.toString();
//		System.out.println(values);
		
//		int[] accMoney = ledger;
//		System.out.println(accMoney);

//		for (int i = 0; i < ledger.length; i++) {
//			String values = ledger[i];
//			System.out.println(values);
//			// 입출금 요청이 양수면 입금, 음수면 출금
//			if (account < m) { // 출금 요청 거절
//				account = account;
//
//			} else {
//				account += ledger[i];
//				System.out.println(account);
//			}
//
//		}
		
		for (int i = 0; i < ledger.length; i++) {
            if (ledger[i] < 0) { // 출금 요청인 경우
                if (account < m) {
                    // 잔액이 부족하면 출금 거절
                    System.out.println("출금 요청 거절: 잔액 부족 (" + ledger[i] + "원 출금 요청)");
                } else {
                    // 잔액이 충분하면 출금 처리
                    account += ledger[i];
                    System.out.println("출금 완료: " + ledger[i] + "원, 현재 잔액: " + account + "원");
                }
            } else { // 입금 요청인 경우
                account += ledger[i];
                System.out.println("입금 완료: " + ledger[i] + "원, 현재 잔액: " + account + "원");
            }
        }
		
		return account;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int m = 5000;
		int[] ledger = { 10000, -13000, -4000, -2000, 6500, -20000 };

		int result = s.solution(m, ledger);
		System.out.println(result);
	}

}
