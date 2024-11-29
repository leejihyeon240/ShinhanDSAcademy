package chapter05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chapter05.execute.Calculator;
import chapter05.execute.CalculatorImpl;
import chapter05.execute.Timer;

@Configuration
@EnableAspectJAutoProxy
public class Beans {
	@Bean
	public Calculator calc() {
		return new CalculatorImpl();
	}

	@Bean
	public Timer timer() {
		return new Timer();
	}
}
