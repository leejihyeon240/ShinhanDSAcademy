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
					// 첫 번째 값(회원 등급)이 같으면, 두 번째 값(티켓 구매 수량)을 기준으로 내림차순 정렬
					return o2[1] - o1[1];
				}
				// 오름차순 정렬
				return o1[0] - o2[0];
			}
		});

		// 정렬 결과 출력
		System.out.println("정렬된 요청 배열:");
		for (int[] request : requests) {
			System.out.println(Arrays.toString(request));
		}

		for (int i = 0; i < requests.length; i++) {
			if (tickets - soldTickets - requests[i][1] >= 0) {
				soldTickets += requests[i][1];
			} else {
				System.out.println("티켓 판매 금지. 티켓이 부족합니다.");
			}
		}

		return soldTickets;
	}

	public static void main(String[] args) {
		Land s = new Land();

		// 남은 표
		int tickets = 10;
		// 회원 등급, 티켓 구매 수량
		// requests[i][0]: 회원 등급
		// requests[i][1]: 티켓 구매 수량
		int[][] requests = { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } };

		int result = s.solution(tickets, requests);
		System.out.println(result);
	}

}
