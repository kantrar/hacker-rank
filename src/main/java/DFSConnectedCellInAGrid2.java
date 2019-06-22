public class DFSConnectedCellInAGrid2 {
	static int maxRegion(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (visited[i][j] || grid[i][j] == 0) {
					continue;
				}

				maxArea = Math.max(maxArea, findRegion(grid, i, j, visited));
			}
		}

		return maxArea;
	}

	private static int findRegion(int[][] grid, int row, int col, boolean[][] visited) {
		visited[row][col] = true;

		int[] dr = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dc = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

		int total = 1;

		for (int i = 0; i < 8; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];

			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1
					&& !visited[newRow][newCol]) {
				total += findRegion(grid, newRow, newCol, visited);
			}
		}

		return total;
	}
}
