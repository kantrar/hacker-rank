import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CoinOnTheTable {

	public static class Grid {
		int row;
		int col;
		char direction;
		int changeCount;
		int count;

		public Grid(int r, int c, char d) {
			this.row = r;
			this.col = c;
			this.direction = d;
			this.changeCount = Integer.MAX_VALUE;
			this.count = 0;
		}
	}

	static int coinOnTheTable(int k, String[] board) {
		Grid[][] grids = new Grid[board.length][board[0].length()];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				grids[i][j] = new Grid(i, j, board[i].charAt(j));
			}
		}

		return BFS(grids, 0, 0, k);
	}

	static int BFS(Grid[][] grids, int row, int col, int maxNumber) {
		Queue<Grid> queue = new LinkedList<>();
		grids[row][col].changeCount = 0;
		queue.add(grids[row][col]);

		int minChange = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Grid currentGrid = queue.remove();

			if (currentGrid.count > maxNumber) {
				break;
			}

			int currentRow = currentGrid.row;
			int currentCol = currentGrid.col;

			if (currentGrid.direction == '*') {
				if (currentGrid.changeCount < minChange) {
					minChange = currentGrid.changeCount;
				}
			} else {
				appendGridToQueue(queue, currentRow, currentCol - 1, grids, currentGrid, 'L');
				appendGridToQueue(queue, currentRow, currentCol + 1, grids, currentGrid, 'R');
				appendGridToQueue(queue, currentRow - 1, currentCol, grids, currentGrid, 'U');
				appendGridToQueue(queue, currentRow + 1, currentCol, grids, currentGrid, 'D');
			}

		}

		return minChange == Integer.MAX_VALUE ? -1 : minChange;
	}

	static void appendGridToQueue(Queue<Grid> queue, int row, int col, Grid[][] grids, Grid currentGrid,
			char expectedDirection) {
		int maxRow = grids.length;
		int maxCol = grids[0].length;

		if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
			return;
		}

		Grid grid = grids[row][col];

		int newChangeCount;

		if (currentGrid.direction == expectedDirection) {
			newChangeCount = currentGrid.changeCount;
		} else {
			newChangeCount = currentGrid.changeCount + 1;

		}
		if (grid.changeCount < newChangeCount) {
			return;
		}

		grid.changeCount = newChangeCount;
		grid.count = currentGrid.count + 1;

		if (!queue.contains(grid)) {
			queue.add(grid);
		}
	}

	// Timeout, incomplete
	static int coinOnTheTable3(int k, String[] board) {
		char[][] grids = new char[board.length][board[0].length()];
		int[][] visited = new int[board.length][board[0].length()];

		int targetRow = 0;
		int targetCol = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				grids[i][j] = board[i].charAt(j);
				visited[i][j] = 0;
				if (grids[i][j] == '*') {
					targetRow = i;
					targetCol = j;
				}
			}
		}

		int result = moveCoinOperation(k, 0, visited, grids, 0, 0, targetRow, targetCol);
		if (result == Integer.MAX_VALUE) {
			return -1;
		}
		return result;
	}

	private static int moveCoinOperation(int remainingTime, int changeCount, int[][] visited, char[][] grids, int currentRow,
			int currentCol, int targetRow, int targetCol) {

		if (targetRow - currentRow + targetCol - currentCol > remainingTime) {
			return Integer.MAX_VALUE;
		}

		if (remainingTime < 0) {
			return Integer.MAX_VALUE;
		}

		if (!validateGrid(grids, currentRow, currentCol)) {
			return Integer.MAX_VALUE;
		}

		if (visited[currentRow][currentCol] == -1) {
			return Integer.MAX_VALUE;
		}

		if (visited[currentRow][currentCol] == -2) {
			return Integer.MAX_VALUE;
		}

		visited[currentRow][currentCol] = -2;

		char currentChar = grids[currentRow][currentCol];

		List<Integer> answers = new ArrayList<>();

		int newTime = remainingTime - 1;
		int newChangeCount = changeCount + 1;

		switch (currentChar) {
		case 'L':
			answers.add(
					moveCoinOperation(newTime, changeCount, visited, grids, currentRow, currentCol - 1, targetRow, targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow, currentCol + 1, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow - 1, currentCol, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow + 1, currentCol, targetRow,
							targetCol));
			break;
		case 'R':
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow, currentCol - 1, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, changeCount, visited, grids, currentRow, currentCol + 1, targetRow, targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow - 1, currentCol, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow + 1, currentCol, targetRow,
							targetCol));
			break;
		case 'U':
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow, currentCol - 1, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow, currentCol + 1, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, changeCount, visited, grids, currentRow - 1, currentCol, targetRow, targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow + 1, currentCol, targetRow,
							targetCol));
			break;
		case 'D':
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow, currentCol - 1, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow, currentCol + 1, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, newChangeCount, visited, grids, currentRow - 1, currentCol, targetRow,
							targetCol));
			answers.add(
					moveCoinOperation(newTime, changeCount, visited, grids, currentRow + 1, currentCol, targetRow, targetCol));
			break;
		case '*':
			visited[currentRow][currentCol] = 0;
			return changeCount;
		}

		Collections.sort(answers);

		int result = answers.get(0);

		if (result == Integer.MAX_VALUE) {
			visited[currentRow][currentCol] = -1;
		}

		return result;
	}

	// Minintepret the problem
	// This solution is place find the minimum change operations that does not exceed k
	static int cointOnTheTable2(int k, String[] board) {
		char[][] grids = new char[board.length][board[0].length()];
		int[][] visited = new int[board.length][board[0].length()];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				grids[i][j] = board[i].charAt(j);
				visited[i][j] = 0;
			}
		}

		int remainingChange = moveCoin(k, visited, grids, 0, 0);
		if (remainingChange == -1) {
			return -1;
		}
		return (k - remainingChange);
	}

	static int moveCoin(int remainingChange, int[][] visited, char[][] grids, int currentRow, int currentCol) {
		if (remainingChange < 0) {
			return -1;
		}

		if (!validateGrid(grids, currentRow, currentCol)) {
			return -1;
		}

		if (visited[currentRow][currentCol] == -2) {
			return -1;
		}

		if (visited[currentRow][currentCol] == -1 && remainingChange == 0) {
			return visited[currentRow][currentCol];
		}

		visited[currentRow][currentCol] = -2;

		List<Integer> answers = new ArrayList<>();
		char currentChar = grids[currentRow][currentCol];

		int newChange = remainingChange - 1;
		switch (currentChar) {
		case 'L':
			answers.add(moveCoin(remainingChange, visited, grids, currentRow, currentCol - 1));
			answers.add(moveCoin(newChange, visited, grids, currentRow, currentCol + 1));
			answers.add(moveCoin(newChange, visited, grids, currentRow - 1, currentCol));
			answers.add(moveCoin(newChange, visited, grids, currentRow + 1, currentCol));
			break;
		case 'R':
			answers.add(moveCoin(newChange, visited, grids, currentRow, currentCol - 1));
			answers.add(moveCoin(remainingChange, visited, grids, currentRow, currentCol + 1));
			answers.add(moveCoin(newChange, visited, grids, currentRow - 1, currentCol));
			answers.add(moveCoin(newChange, visited, grids, currentRow + 1, currentCol));
			break;
		case 'U':
			answers.add(moveCoin(newChange, visited, grids, currentRow, currentCol - 1));
			answers.add(moveCoin(newChange, visited, grids, currentRow, currentCol + 1));
			answers.add(moveCoin(remainingChange, visited, grids, currentRow - 1, currentCol));
			answers.add(moveCoin(newChange, visited, grids, currentRow + 1, currentCol));
			break;
		case 'D':
			answers.add(moveCoin(newChange, visited, grids, currentRow, currentCol - 1));
			answers.add(moveCoin(newChange, visited, grids, currentRow, currentCol + 1));
			answers.add(moveCoin(newChange, visited, grids, currentRow - 1, currentCol));
			answers.add(moveCoin(remainingChange, visited, grids, currentRow + 1, currentCol));
			break;
		case '*':
			visited[currentRow][currentCol] = 0;
			return remainingChange;
		}

		if (answers.isEmpty()) {
			return -1;
		}

		Collections.sort(answers, Collections.reverseOrder());
		int result = answers.get(0);

		if (remainingChange == 0) {
			visited[currentRow][currentCol] = result;
		} else {
			visited[currentRow][currentCol] = 0;
		}

		return result;
	}

	static boolean validateGrid(char[][] grids, int row, int col) {
		if (row < 0 || row >= grids.length || col < 0 || col >= grids[0].length) {
			return false;
		} else {
			return true;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nmk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nmk[0].trim());

		int m = Integer.parseInt(nmk[1].trim());

		int k = Integer.parseInt(nmk[2].trim());

		String[] board = new String[n];

		for (int boardItr = 0; boardItr < n; boardItr++) {
			String boardItem = scanner.nextLine();
			board[boardItr] = boardItem;
		}

		int result = coinOnTheTable(k, board);

		System.out.println(result);
	}
}
