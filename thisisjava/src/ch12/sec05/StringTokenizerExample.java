package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		String data1 = "홍길동&이수홍,박연수";
		String[] arr = data1.split("&|,");
		for (String token : arr) {
			System.out.println(token);
		}
		System.out.println();

		String data2 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data2, "/");
		while (st.hasMoreTokens()) {  // hasMoreTokens 남아 있는 문자열이 있는지 여부
			// 더 이상 가져올 문자열이 없다면 예외를 발생시키기 때문에
			// nextToken을 사용하기 전에 hasMoreTokens로 문자열이 있는지 먼저 조사하기
			String token = st.nextToken();
			System.out.println(token);
		}
	}

}
