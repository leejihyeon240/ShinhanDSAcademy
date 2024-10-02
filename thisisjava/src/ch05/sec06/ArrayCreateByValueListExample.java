package ch05.sec06;

public class ArrayCreateByValueListExample {

	public static void main(String[] args) {
		int[] scores = { 83, 90, 87 };

		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += scores[i];

		}
		System.out.println("총합 : " + sum);

		double avg = (double) sum / 3; // 형변환 중요
		System.out.println("평균 : " + avg);
	}

}
