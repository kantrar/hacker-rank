public class DFSConnectedCellInAGrid {
	static int maxRegion(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int maxArea = -1;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					continue;
				}

				if (visited[i][j]) {
					continue;
				}

				int area = DFS(grid, i, j, visited, 0);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}

	private static int DFS(int[][] grid, int row, int col, boolean[][] visited, int currentArea) {
		visited[row][col] = true;
		currentArea++;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int newRow = row + i;
				int newCol = col + j;

				if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
					continue;
				}

				if (visited[newRow][newCol] || grid[newRow][newCol] == 0) {
					continue;
				}

				currentArea = DFS(grid, newRow, newCol, visited, currentArea);
			}
		}

		return currentArea;
	}

	public static void main(String[] args) {
		int result = maxRegion(new int[][] {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}});
		System.out.println(result);
	}
}

