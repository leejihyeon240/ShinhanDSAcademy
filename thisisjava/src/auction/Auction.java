package auction;

import java.util.Arrays;

public class Auction {

	public int[] solution(int n, int[] amounts) {
		int[] answer = { 0 };

		// n은 경매 물품 수, amounts는 초기 자본
		
		// 항상 자본이 가장 많이 남은 참가자가 물품을 낙찰
		// 두번째 자본 +10000
		
		// 자본이 가장 많이 남은 참가자가 여러 명이라면, 번호가 가장 낮은 참가자가 물품을 낙찰
		// 번호가 가장 낮은 참가자의 자본 모두
		
		// 물품 번호가 낮은 순으로 낙찰된 금액
		return answer;
	}

	public static void main(String[] args) {

		Auction m = new Auction();

		int n = 4;

		int[] amounts = {1000000, 490000, 700000, 290000};
		
		int[] answer = m.solution(n, amounts);

		System.out.println(Arrays.toString(answer));
		
	}

}
