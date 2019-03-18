import java.util.Scanner;

public class MrKMarsh {

	// timeout, even worse
	static int kMarsh(String[] grid) {
		int row = grid.length;
		int col = grid[0].length();

		int[][] downMatrix = new int[row][col];
		int downCount = 0;
		int[][] leftMatrix = new int[row][col];
		int leftCount = 0;
		for (int i = 0; i < row; i++) {
			leftCount = 0;
			for (int j = 0; j < col; j++) {
				if (i == 0) {
					if (grid[i].charAt(j) == 'x') {
						downMatrix[i][j] = -1;
						leftMatrix[i][j] = -1;
						leftCount = 0;
					} else {
						downMatrix[i][j] = downCount;
						leftMatrix[i][j] = leftCount;
						leftCount++;
					}
				} else {
					if (grid[i].charAt(j) == 'x') {
						downMatrix[i][j] = -1;
						leftMatrix[i][j] = -1;
						leftCount = 0;
					} else {
						downMatrix[i][j] = downMatrix[i - 1][j] + 1;
						leftMatrix[i][j] = leftCount;
						leftCount++;
					}
				}
			}
		}


		int result = getMaximumArea(downMatrix, leftMatrix, 0, row - 1, 0, col - 1);
		System.out.println(result == -1 ? "impossible" : result);
		return result;
	}

	private static int getMaximumArea(int[][] downMatrix, int[][] leftMatrix, int topRow, int bottomRow, int leftCol,
			int rightCol) {

		int max = -1;
		for (int row = topRow; row <= bottomRow; row++) {
			for (int col = leftCol; col <= rightCol; col++) {
				for (int otherRow = row + 1; otherRow <= bottomRow; otherRow++) {
					for (int otherCol = col + 1; otherCol <= rightCol; otherCol++) {
						boolean topNoMarsh = (leftMatrix[row][otherCol] != -1 && leftMatrix[row][col] != -1)
								&& leftMatrix[row][otherCol] - leftMatrix[row][col] == otherCol - col;
						boolean bottomNoMarsh = (leftMatrix[otherRow][otherCol] != -1 && leftMatrix[otherRow][col] != -1)
								&& leftMatrix[otherRow][otherCol] - leftMatrix[otherRow][col] == otherCol - col;
						boolean leftNoMarsh = (downMatrix[otherRow][col] != -1 && downMatrix[row][col] != -1)
								&& downMatrix[otherRow][col] - downMatrix[row][col] == otherRow - row;
						boolean rightNoMarsh = (downMatrix[otherRow][otherCol] != -1 && downMatrix[otherRow][col] != -1)
								&& downMatrix[otherRow][otherCol] - downMatrix[row][otherCol] == otherRow - row;

						if (topNoMarsh && bottomNoMarsh && leftNoMarsh && rightNoMarsh) {
							max = Math.max(max, (otherCol - col + otherRow - row) * 2);
						}
					}
				}
			}
		}

		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0].trim());

		int n = Integer.parseInt(mn[1].trim());

		String[] grid = new String[m];

		for (int gridItr = 0; gridItr < m; gridItr++) {
			String gridItem = scanner.nextLine();
			grid[gridItr] = gridItem;
		}

		kMarsh(grid);
	}

	// Timeout
	static void kMarsh2(String[] grid) {
		int row = grid.length;
		int col = grid[0].length();

		boolean[][] marsh = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				marsh[i][j] = (grid[i].charAt(j) == 'x');
			}
		}
		int result = getMaximumArea2(marsh, 0, row - 1, 0, col - 1);
		System.out.println(result == -1 ? "impossible" : result);
	}

	private static int getMaximumArea2(boolean[][] marsh, int topRow, int bottomRow, int leftCol, int rightCol) {
		if (topRow >= marsh.length || bottomRow < 0 || leftCol >= marsh[0].length || rightCol < 0) {
			return -1;
		}

		if (topRow >= bottomRow || leftCol >= rightCol) {
			return -1;
		}

		for (int i = topRow; i <= bottomRow; i++) {
			if (marsh[i][leftCol] == true) {
				int max1 = getMaximumArea2(marsh, i + 1, bottomRow, leftCol, rightCol);
				int max2 = getMaximumArea2(marsh, topRow, i - 1, leftCol, rightCol);
				int max3 = getMaximumArea2(marsh, topRow, bottomRow, leftCol + 1, rightCol);
				int max = Math.max(max1, max2);
				max = Math.max(max, max3);
				return max;
			}

			if (marsh[i][rightCol] == true) {
				int max1 = getMaximumArea2(marsh, i + 1, bottomRow, leftCol, rightCol);
				int max2 = getMaximumArea2(marsh, topRow, i - 1, leftCol, rightCol);
				int max3 = getMaximumArea2(marsh, topRow, bottomRow, leftCol, rightCol - 1);
				int max = Math.max(max1, max2);
				max = Math.max(max, max3);
				return max;
			}
		}

		for (int i = leftCol; i <= rightCol; i++) {
			if (marsh[topRow][i] == true) {
				int max1 = getMaximumArea2(marsh, topRow, bottomRow, leftCol, i - 1);
				int max2 = getMaximumArea2(marsh, topRow, bottomRow, i + 1, rightCol);
				int max3 = getMaximumArea2(marsh, topRow + 1, bottomRow, leftCol, rightCol);
				int max = Math.max(max1, max2);
				max = Math.max(max, max3);
				return max;
			}

			if (marsh[bottomRow][i] == true) {
				int max1 = getMaximumArea2(marsh, topRow, bottomRow, leftCol, i - 1);
				int max2 = getMaximumArea2(marsh, topRow, bottomRow, i + 1, rightCol);
				int max3 = getMaximumArea2(marsh, topRow, bottomRow - 1, leftCol, rightCol);
				int max = Math.max(max1, max2);
				max = Math.max(max, max3);
				return max;
			}
		}

		return ((bottomRow - topRow) + (rightCol - leftCol)) * 2;
	}
}
