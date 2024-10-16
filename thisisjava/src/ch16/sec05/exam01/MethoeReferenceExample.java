package ch16.sec05.exam01;

import ch14.sec06.exam01.Caclulator;

public class MethoeReferenceExample {

	public static void main(String[] args) {
		Person person = new Person();

		// 아래 3개 똑같음
		// 메서드 참조
		person.action(Computer::staticMethod);

		// 익명 구현 객체
		person.action(new Calcuable() {

			@Override
			public double calc(double x, double y) {
				// TODO Auto-generated method stub
				return Computer.staticMethod(x, y);
			}
		});

		// 람다식
		person.action((x, y) -> Computer.staticMethod(x, y));

		Computer com = new Computer();

		person.action(com::instanceMethod);

	}

}
