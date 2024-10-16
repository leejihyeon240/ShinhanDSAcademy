package membership;

public class Membership {
	
	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		
		int[] answer = { 0, 0 };
		
		int[] paySumThis = new int[periods.length];
		int[] paySumNext = new int[periods.length];
		
		// 고객들의 가입기간을 담은 1차원 정수 배열 periods
		// 고객들의 납부 내역을 담은 2차원 정수 배열 payments
		for (int i = 0; i < periods.length; i++) {
			// 이번 달의 연간 납부 금액
			for (int j = 0; j < 12; j++) {
				paySumThis[i] += payments[i][j];
			}
			// 다음 달의 연간 납부 금액 - 다음 달 예측 금액
			for (int j = 1; j < 12; j++) {
				paySumNext[i] += payments[i][j];
			}
			// 고객들의 납부 예정 금액 estimates
			paySumNext[i] += estimates[i]; // 다음 달 예측 금액 더하기

			// 이번 달에는 VIP지만, 다음 달에는 VIP가 아닌 고객에게 알림
			
			// 이번 달에 VIP가 되는 두자기 경우
			boolean vipThis1 = periods[i] >= 24 && periods[i] < 60 && paySumThis[i] >= 900000;
			boolean vipThis2 = periods[i] >= 60 && paySumThis[i] >= 600000;
			// 다음 달에 VIP가 되는 두가지 경우
			boolean vipNext1 = (periods[i] + 1) >= 24 && (periods[i] + 1) < 60 && paySumNext[i] >= 900000;
			boolean vipNext2 = (periods[i] + 1) >= 60 && paySumNext[i] >= 600000;

			// 이번 달 VIP 아니지만 다음 달에 VIP 되는 고객
			if (!(vipThis1 || vipThis2) && (vipNext1 || vipNext2)) {
				answer[0] += 1;
			}
			// 이번 달에 VIP 이지만 다음 달에 VIP 아니게 되는 고객
			else if ((vipThis1 || vipThis2) && !(vipNext1 || vipNext2)) {
				answer[1] += 1;
			}
			
		}
		
		// 이번 달에는 VIP가 아니지만 다음 달에 VIP가되는 고객의 수
		// 이번 달에는 VIP지만 다음 달에는 VIP가 아니게 되는 고객의 수
		return answer;
	}

	
	public static void main(String[] args) {
		
		Membership m = new Membership();
		
		int[] periods = { 24, 59, 59, 60 };
		
		int[][] payments = { { 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 } };
		
		int[] estimates = { 350000, 50000, 40000, 50000 };
		
		int[] answer = m.solution(periods, payments, estimates);
		
		System.out.println("이번 달 VIP 아니지만 다음 달에 VIP되는 고객: " + answer[0]);
		System.out.println("이번 달에 VIP 이지만 다음 달에 VIP 아니게 되는 고객: " + answer[1]);

	}

}
