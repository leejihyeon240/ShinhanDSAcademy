package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeefPrintExample {

	public static void main(String[] args) {

		// Thread 객체
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);

					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
