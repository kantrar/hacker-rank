public class NQueen {
	public static void main(String[] args) {
		int[][] board = initBoard();
		for (int i = 0; i < board.length; i++) {
			board = initBoard();
			board[i][0] = 1;
			solve(board, 1);
			board[i][0] = 0;

			System.out.println();
		}
	}

	private static int[][] initBoard() {
		return new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
	}

	private static boolean solve(int[][] board, int col) {
		if (col >= board.length) {
			printBoard(board);
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;

				if (solve(board, col + 1)) {
					return true;
				}

				board[i][col] = 0;
			}
		}
		// 0 1 0 0
		// 0 0 0 1
		// 1 0 0 0
		// 0 0 1 0
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
