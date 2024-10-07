package ch06;

public class InitEx {

	InitEx() { // 객체 생성 시
		System.out.println("여기는 생성자");
	}

	// static 초기화 블록 (클래스를 로드, 한번만)
	static {
		System.out.println("static 초기화 블록");
	}

	// instance 초기화 블록 (객체 생성 시)
	{
		System.out.println("instance 초기화 블록");
	}

	public static void main(String[] args) {
		System.out.println("main 메서드 실행");
		InitEx ie = new InitEx();
		InitEx ie2 = new InitEx();
	}

}
