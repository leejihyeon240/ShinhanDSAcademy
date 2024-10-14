package omok;

public class Board {
	int size;
	String[][] map;

	Board(int size) {
		this.size = size;
		map = new String[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				map[row][col] = ".";
			}
		}
	}

	// 좌표 출력(좌측에 0, 1, 2, 3, … , 18 하단에 A, B, C, … , S 의 좌표 표시)
	public void print() {
		for (int row = 0; row < size; row++) {
			System.out.printf("%-2d", (int) (0 + row));
			for (int col = 0; col < size; col++) {
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}
		System.out.print("  ");
		for (int col = 0; col < size; col++) {
			System.out.print(" " + (char) ('A' + col));
		}
		System.out.println();
	}

	// 돌
	public boolean placeStone(int row, int col, String stone) {
		if (row >= 0 && row < size && col >= 0 && col < size && map[row][col].equals(".")) {
			map[row][col] = stone;
			return true;
		}
		return false;
	}

	// 승리 조건
	public boolean checkWin(String stone) {
		return stoneCheck(stone, 1, 0) || // 가로
				stoneCheck(stone, 0, 1) || // 세로
				stoneCheck(stone, 1, 1) || // 대각선 /
				stoneCheck(stone, 1, -1); // 대각선 \
	}

	// 연속된 돌 체크
	private boolean stoneCheck(String stone, int stoneRow, int stoneCol) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (map[row][col].equals(stone)) {
					if (countStone(row, col, stoneRow, stoneCol, stone) >= 5) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// 돌 개수 세기
	private int countStone(int row, int col, int stoneRow, int stoneCol, String stone) {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			int r = row + i * stoneRow;
			int c = col + i * stoneCol;
			if (r >= 0 && r < size && c >= 0 && c < size && map[r][c].equals(stone)) {
				count++;
			} else { // 돌 연속 x
				break;
			}
		}
		return count;
	}
}