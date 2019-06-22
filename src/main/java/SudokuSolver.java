public class SudokuSolver {
	private static char EMPTY = '.';
	private static boolean[][][] groupSet = new boolean[3][3][9];
	private static boolean[][] rowSet = new boolean[9][9];
	private static boolean[][] colSet = new boolean[9][9];

	public void solveSudoku(char[][] board) {
		groupSet = new boolean[3][3][9];
		rowSet = new boolean[9][9];
		colSet = new boolean[9][9];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != EMPTY) {
					groupSet[i / 3][j / 3][getKey(board[i][j])] = true;
					rowSet[i][getKey(board[i][j])] = true;
					colSet[j][getKey(board[i][j])] = true;
				}
			}
		}

		solve(board);
	}

	private int getKey(char c) {
		return c - '1';
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == EMPTY) {
					for (char c = '1'; c <= '9'; c++) {
						if (rowSet[i][getKey(c)] || colSet[j][getKey(c)] || groupSet[i / 3][j / 3][getKey(c)]) {
							continue;
						}
						if (place(board, c, i, j)) {
							return true;
						}
					}

					return false;
				}
			}
		}

		return true;
	}

	public boolean place(char[][] board, char c, int row, int col) {
		board[row][col] = c;

		rowSet[row][getKey(c)] = true;
		colSet[col][getKey(c)] = true;
		groupSet[row / 3][col / 3][getKey(c)] = true;

		if (solve(board)) {
			return true;
		}

		rowSet[row][getKey(c)] = false;
		colSet[col][getKey(c)] = false;
		groupSet[row / 3][col / 3][getKey(c)] = false;

		board[row][col] = EMPTY;

		return false;
	}
}
