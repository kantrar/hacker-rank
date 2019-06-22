import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
	public int numDistinctIslands(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Set<Set<Integer>> setOfSet = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (visited[i][j] || grid[i][j] == 0) {
					continue;
				}

				Set<Integer> set = new HashSet<>();
				dfs(grid, visited, i, j, i, j, set);

				setOfSet.add(set);
			}
		}

		return setOfSet.size();
	}

	public void dfs(int[][] grid, boolean[][] visited, int row, int col, int parentRow, int parentCol, Set<Integer> set) {
		visited[row][col] = true;
		set.add((parentRow - row) * 1000 + (parentCol - col));

		for (int[] next : getNext(grid, row, col)) {
			if (visited[next[0]][next[1]] || grid[next[0]][next[1]] == 0) {
				continue;
			}

			dfs(grid, visited, next[0], next[1], parentRow, parentCol, set);
		}
	}

	public List<int[]> getNext(int[][] grid, int row, int col) {
		int[] dr = new int[] {0, 0, -1, 1};
		int[] dc = new int[] {-1, 1, 0, 0};

		List<int[]> result = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];

			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
				result.add(new int[] {newRow, newCol});
			}
		}

		return result;
	}
}
