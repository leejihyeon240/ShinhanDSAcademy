package ch09.sec07.land;

import java.util.Arrays;
import java.util.Comparator;

public class Land {

	// 남은 표의 개수 < 구매 개수 : 판매 X
	public int solution(int tickets, int[][] requests) {
		int soldTickets = 0;

		Arrays.sort(requests, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0; i < requests.length ; i++) {
			if(indexOf(requests[i])+ soldTickets > tickets) {
				System.out.println(requests[i]);

			}
		}
		
		return soldTickets;
	}

	public static void main(String[] args) {
		Land s = new Land();

		// 남은 표
		int tickets = 10;
		// 회원 등급, 티켓 구매 수량
		int[][] requests = { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } };

		int result = s.solution(tickets, requests);
		System.out.println(result);
	}

}
