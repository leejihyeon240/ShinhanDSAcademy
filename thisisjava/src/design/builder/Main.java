package design.builder;

public class Main {

	public static void main(String[] args) {
		// 빌더 패턴을 사용한 클래스의 객체 생성
		Member member = new Member.MemberBuilder().setId("hong").setPwd("111").setName("홍길동").build();

		System.out.println("ID: " + member.getId());
		System.out.println("Password: " + member.getPwd());
		System.out.println("Name: " + member.getName());
	}
}
