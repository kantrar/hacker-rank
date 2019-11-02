import java.util.HashSet;
import java.util.Set;

public class RegionsCutBySlashes {
	public int regionsBySlashes(String[] grid) {
		int res = 0;
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				res += dfs(grid, i, j, 1, -9, -9, visited);
				res += dfs(grid, i, j, 2, -9, -9, visited);
				res += dfs(grid, i, j, 3, -9, -9, visited);
				res += dfs(grid, i, j, 4, -9, -9, visited);
			}
		}
		return res;
	}

	private int[][] moves = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

	private int dfs(String[] grid, int row, int col, int piece, int prevRow, int prevCol, Set<Integer> visited) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length()) {
			return 0;
		}
		if (!visited.add(row * 10000 + col * 100 + piece)) {
			return 0;
		}
		char current = grid[row].charAt(col);
		if (current == ' ') {
			for (int i = 1; i <= 4; i++) {
				visited.add(row * 10000 + col * 100 + i);
			}
			for (int[] move : moves) {
				int nr = row + move[0];
				int nc = col + move[1];
				if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[nr].length()) {
					continue;
				}
				for (int p = 1; p <= 4; p++) {
					dfs(grid, nr, nc, p, row, col, visited);
				}
			}
			return 1;
		}
		if (current == '/') {
			if (prevRow == -9) {
				visited.add(row * 10000 + col * 100 + 1);
				visited.add(row * 10000 + col * 100 + 2);
				if (piece == 1) {
					dfs(grid, row, col - 1, 4, row, col, visited);
				} else {
					dfs(grid, row - 1, col, 3, row, col, visited);
				}
			} else if ((prevRow == row && prevCol + 1 == col) || (prevRow + 1 == row && prevCol == col)) {
				// from top/left side
				visited.add(row * 10000 + col * 100 + 1);
				visited.add(row * 10000 + col * 100 + 2);
				if (piece == 1) {
					dfs(grid, row, col - 1, 4, row, col, visited);
				} else {
					dfs(grid, row - 1, col, 3, row, col, visited);
				}
			} else {
				visited.add(row * 10000 + col * 100 + 3);
				visited.add(row * 10000 + col * 100 + 4);
				if (piece == 3) {
					dfs(grid, row, col + 1, 2, row, col, visited);
				} else {
					dfs(grid, row + 1, col, 1, row, col, visited);
				}
			}
			return 1;
		}
		if (current == '\\') {
			if (prevRow == -9) {
				visited.add(row * 10000 + col * 100 + 2);
				visited.add(row * 10000 + col * 100 + 3);
				if (piece == 2) {
					dfs(grid, row + 1, col, 1, row, col, visited);
				} else {
					dfs(grid, row, col - 1, 4, row, col, visited);
				}
			} else if ((prevRow == row && prevCol + 1 == col) || (prevRow - 1 == row && prevCol == col)) {
				// from bottom/left side
				visited.add(row * 10000 + col * 100 + 2);
				visited.add(row * 10000 + col * 100 + 3);
				if (piece == 2) {
					dfs(grid, row + 1, col, 1, row, col, visited);
				} else {
					dfs(grid, row, col - 1, 4, row, col, visited);
				}
			} else {
				visited.add(row * 10000 + col * 100 + 1);
				visited.add(row * 10000 + col * 100 + 4);
				if (piece == 1) {
					dfs(grid, row, col + 1, 2, row, col, visited);
				} else {
					dfs(grid, row - 1, col, 3, row, col, visited);
				}
			}
			return 1;
		}
		return 0;
	}
}
