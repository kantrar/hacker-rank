import java.util.Stack;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int max = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					max = Math.max(max, dfs(grid, i, j, visited));
				}
			}
		}

		return max;
	}

	public int dfs(int[][] grid, int row, int col, boolean[][] visited) {
		int[][] moves = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		int total = 0;
		Stack<int[]> stack = new Stack<>();

		stack.push(new int[] {row, col});
		visited[row][col] = true;

		while (!stack.isEmpty()) {
			int[] current = stack.pop();
			total++;

			for (int i = 0; i < moves.length; i++) {
				int newRow = current[0] + moves[i][0];
				int newCol = current[1] + moves[i][1];
				if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
					continue;
				}

				if (visited[newRow][newCol] || grid[newRow][newCol] == 0) {
					continue;
				}
				visited[newRow][newCol] = true;

				stack.push(new int[] {newRow, newCol});
			}
		}

		return total;
	}
}
