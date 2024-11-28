package chapter02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAOImpl();
	}
	
	@Bean
	public MemberService memberService() {
		MemberServiceImpl service = new MemberServiceImpl();
		service.setMemberDAO(memberDAO()); // 주입
		return service;
	}
}
