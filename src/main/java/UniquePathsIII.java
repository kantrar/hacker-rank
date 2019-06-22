import java.util.ArrayList;
import java.util.List;

public class UniquePathsIII {
	public int uniquePathsIII(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		// backtracking
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int startRow = 0;
		int startCol = 0;
		int requiredWalks = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					startRow = i;
					startCol = j;
				} else if (grid[i][j] == 0) {
					requiredWalks++;
				}
			}
		}

		return findPath(grid, startRow, startCol, visited, requiredWalks);
	}

	public int findPath(int[][] grid, int row, int col, boolean[][] visited, int requiredWalks) {
		visited[row][col] = true;

		int total = 0;

		for (int[] next : getNext(grid, row, col)) {
			if (!visited[next[0]][next[1]] && grid[next[0]][next[1]] != -1) {
				if (grid[next[0]][next[1]] == 2 && requiredWalks == 0) {
					visited[row][col] = false;
					return 1;
				} else if (grid[next[0]][next[1]] == 2) {
					continue;
				} else {
					total += findPath(grid, next[0], next[1], visited, requiredWalks - 1);
				}
			}
		}

		visited[row][col] = false;

		return total;
	}

	public List<int[]> getNext(int[][] grid, int row, int col) {
		List<int[]> result = new ArrayList<>();

		int[] dr = new int[] {0, 0, -1, 1};
		int[] dc = new int[] {-1, 1, 0, 0};

		for (int i = 0; i < dr.length; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];

			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
				result.add(new int[] {newRow, newCol});
			}
		}

		return result;
	}
}
