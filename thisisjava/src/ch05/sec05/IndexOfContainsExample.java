package ch05.sec05;

public class IndexOfContainsExample {

	public static void main(String[] args) {
		String subject = "자바 프로그래밍";

		// indexOf 문자열의 위치
		int location = subject.indexOf("프로그래밍");

		System.out.println(location);
		String subString = subject.substring(location);
		System.out.println(subString);

		location = subject.indexOf("자바");
		if (location != -1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련 없는 책이군요");
		}

		// contains 포함
		boolean result = subject.contains("자바");
		if (result) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련 없는 책이군요");

		}

		String filename = "이력서.docx";
		// 한글 파일명 -> 영문(숫자) 변환
		// xxxxx.docx

		// 파일명(현재 밀리세컨드) 변경
		// . 위치 가져오기
		// . 위치부터 끝까지
		// System.currentTimemiles() +
		System.out.println(filename.substring(filename.indexOf(".")));
		filename = System.currentTimeMillis() + filename.substring(filename.indexOf("."));
		System.out.println(filename);
		
		String filename2 = "2024.10.02_이력서.docx";
		filename = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
		
	}

}
