package ch03;

public class OperatorEx {

	public static void main(String[] args) {

		int a = 10;
		System.out.println(a >= 10 && a < 20);
		System.out.println(a >= 10 && a > 20);
		System.out.println(a >= 10 || a > 20);

		// 아이디가 admin인지 체크
		String id = null;

		if (id != null && id.equals("admin")) { // &는 오류(둘 다 T여야 하기 때문, &&는 앞에서 이미 F이기 때문에 뒤에 확인할 필요가 없음)
			System.out.println("통과");
		}
	}

}
