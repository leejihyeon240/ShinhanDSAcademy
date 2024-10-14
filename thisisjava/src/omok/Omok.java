package omok;

import java.util.Scanner;

public class Omok {
	public static void main(String[] args) {
		Player user = new Player("사용자", "O");
		Player computer = new Player("컴퓨터", "X");
		Board board = new Board(19);
		play(board, user, computer);
		Scanner scanner = new Scanner(System.in);
		Player currentPlayer = user;
		while (true) {
			board.print();
			System.out.print(currentPlayer.name + "> ");
			String input = scanner.nextLine();
			int[] position = parseInput(input);
			if (position != null && board.placeStone(position[0], position[1], currentPlayer.stone)) {
				// 승리자 찾기
				if (board.checkWin(currentPlayer.stone)) {
					board.print();
					System.out.println(currentPlayer.name + " 승리!");
					break;
				}
				// 현재에서 다음 플레이어로 바꾸기
				currentPlayer = (currentPlayer == user) ? computer : user;
			} else {
				System.out.println("다시 입력하세요.");
			}
		}
	}

	private static void play(Board board, Player user, Player computer) {
		board.print();
	}

	private static int[] parseInput(String input) {
		// 입력한 문자열 길이가 3이면 X
		if (input.length() < 3)
			return null;
		// 열 문자
		char columnChar = input.charAt(0);
		// 행 문자
		int row = Integer.parseInt(input.substring(2).trim());
		// 문자 --> 숫자
		int column = columnChar - 'A';
		// ? : 배열로 변환
		return (row >= 1 && row <= 19 && column >= 0 && column < 19) ? new int[] { row, column } : null;
	}
}
