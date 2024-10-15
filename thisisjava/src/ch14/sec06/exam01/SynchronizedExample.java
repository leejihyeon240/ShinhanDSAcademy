package ch14.sec06.exam01;

public class SynchronizedExample {

	public static void main(String[] args) {
		Caclulator caclulator = new Caclulator();

		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(caclulator);
		user1Thread.start();

		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(caclulator);
		user2Thread.start();
	}

}
