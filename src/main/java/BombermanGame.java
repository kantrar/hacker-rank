public class BombermanGame {
	static String[] bomberMan(int n, String[] grid) {
		if (n == 1) {
			return grid;
		}

		String[] answer = gridOfBomb(grid.length, grid[0].length());

		if (n % 2 == 0) {
			return answer;
		}

		bomb(grid, answer);

		if (n % 4 == 3) {
			return answer;
		}

		if (n % 4 == 1) {
			String[] a = gridOfBomb(grid.length, grid[0].length());
			bomb(answer, a);
			return a;
		}

		return answer;
	}

	private static void bomb(String[] grid, String[] answer) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				if (grid[i].charAt(j) == 'O') {
					setGridAndNeighborToEmpty(answer, i, j);
				}
			}
		}
	}

	private static String[] gridOfBomb(int row, int col) {
		String[] answer = new String[row];
		String stringForEachRow = "";

		for (int i = 0; i < col; i++) {
			stringForEachRow = stringForEachRow + "O";
		}

		for (int i = 0; i < row; i++) {
			answer[i] = stringForEachRow;
		}
		return answer;
	}

	private static void setGridAndNeighborToEmpty(String[] answer, int row, int col) {
		for (int i = -1; i <= 1; i++) {
			setGridToEmpty(answer, row, col + i);
			setGridToEmpty(answer, row + i, col);
		}
	}

	private static void setGridToEmpty(String[] answer, int row, int col) {
		if (row < 0 || row >= answer.length || col < 0 || col >= answer[row].length()) {
			return;
		}

		StringBuilder builder = new StringBuilder(answer[row]);
		builder.setCharAt(col, '.');
		answer[row] = builder.toString();
	}
}
