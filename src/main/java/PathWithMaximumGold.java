public class PathWithMaximumGold {
	int[][] moves = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	int[] excludedState = new int[] {1, 0, 3, 2};

	public int getMaximumGold(int[][] grid) {
		int max = 0;
		Integer[][][] dp = new Integer[grid.length][grid[0].length][moves.length];
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != 0) {
					for (int state = 0; state < moves.length; state++) {
						max = Math.max(max, dfs(grid, i, j, dp, visited, state));
					}
				}
			}
		}
		return max;
	}

	public int dfs(int[][] grid, int row, int col, Integer[][][] dp, boolean[][] visited, int state) {
		if (visited[row][col]) {
			return 0;
		}
		visited[row][col] = true;

		int nr = row + moves[state][0], nc = col + moves[state][1];
		if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] != 0) {
			int max = grid[row][col];
			for (int i = 0; i < moves.length; i++) {
				if (i == excludedState[state]) {
					continue;
				}
				int res = dfs(grid, nr, nc, dp, visited, i);
				max = Math.max(max, grid[row][col] + res);
			}
			dp[row][col][state] = max;

		} else {
			dp[row][col][state] = grid[row][col];
		}

		visited[row][col] = false;
		return dp[row][col][state];
	}
}
