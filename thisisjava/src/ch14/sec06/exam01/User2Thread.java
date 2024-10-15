package ch14.sec06.exam01;

public class User2Thread extends Thread {
	private Caclulator caclulator;

	public User2Thread() {
		setName("User2Thread");

	}

	public void setCalculator(Caclulator caclulator) {

		this.caclulator = caclulator;

	}

	@Override
	public void run() {
		caclulator.setMemory2(100);

	}
}
