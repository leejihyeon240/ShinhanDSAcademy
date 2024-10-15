package ch14.sec06.exam01;

public class User1Thread extends Thread {
	private Caclulator caclulator;

	public User1Thread() {
		setName("User1Thread");

	}

	public void setCalculator(Caclulator caclulator) {

		this.caclulator = caclulator;

	}

	@Override
	public void run() {
		caclulator.setMemory1(100);

	}

}
