package chapter05.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter05.execute.Calculator;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);

		Calculator c = (Calculator) ctx.getBean("calc");

		long r = c.factorial(10);

		System.out.println(r);
		System.out.println(c.getClass().getName());
	}
}
