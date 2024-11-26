package chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	// 빈등록(메서드)
	// 빈이름(id) : 메서드명
	@Bean
	public Person person() {
		return new Person();
	}
	@Bean
	public Person person2() {
		Person p = new Person();
		p.setName("홍길동");
		p.setAge(30);
		return p;
	}
	@Bean
	public Person person3() {
		return new Person("이순신",20);
	}
}
