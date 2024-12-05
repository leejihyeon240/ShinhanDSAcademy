package kr.co.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JuniTest {

	@Test
	public void test1() {
//		int a = 1/0;
		int count = 10;
		assertEquals(10, count);
		assertTrue(true);
		System.out.println("테스트");
	}

	@Test
	public void test2() {
		System.out.println("테스트2");
	}

	// 매 테스트(메서드)마다 앞에서 실행
	@Before
	public void before() {
		System.out.println("before");
	}

	// 매 테스트(메서드)마다 뒤에서 실행
	@After
	public void after() {
		System.out.println("after");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}
	// @AfterClass - 클래스 내에서 마지막 한번 실행
}
