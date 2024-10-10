package ch07.account;

public class Solution {
	public int solution(int m, int[] ledger) {

		// 초기 잔액 0원
		int account = 0;

		// 입출금 요청이 양수면 입금, 음수면 출금
		for (int i = 0; i < ledger.length; i++) {
            if (ledger[i] < 0) { // 출금 요청인 경우
                if (account + ledger[i] < -m) {
                    System.out.println(ledger[i] + "원 요청 거절 (" + "잔고액: " + account + ")");
                } else {
                    // 출금
                    account += ledger[i];
                    System.out.println(ledger[i] + "원 출금 완료 (" + "잔고액: " + account + ")");
                }
                
            } else { // 입금
                account += ledger[i];
                System.out.println(ledger[i] + "원 입금 완료 (" + "잔고액: " + account + ")");
            }
        }
		
		return account;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

//		int m = 5000;
//		int[] ledger = { 10000, -13000, -4000, -2000, 6500, -20000 };

		int m = 34151;
		int[] ledger = { -34152, -40000, -50000};
		
		int result = s.solution(m, ledger);
		System.out.println(result);
	}

}
