package ch02.sec13;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

		System.out.print("x값 입력: ");
		String strX = scanner.nextLine(); // 사용자로부터 값을 입력 받아 변수에 저장
		int x = Integer.parseInt(strX); // 변수의 값을 정수로 변환해서 x에 저장

		System.out.print("y값 입력: ");
		String strY = scanner.nextLine(); // 사용자로부터 값을 입력 받아 변수에 저장
		int y = Integer.parseInt(strY); // 변수의 값을 정수로 변환해서 y에 저장

		int result = x + y;
		System.out.println("x + y: " + result);
		System.out.println();

		while (true) {
			System.out.print("입력 문자열: ");
			String data = scanner.nextLine();
			if (data.equals("q")) {
				break;
			}
			System.out.println("출력 문자열: " + data);
			System.out.println();
		}

		System.out.println("종료");
	}

}
