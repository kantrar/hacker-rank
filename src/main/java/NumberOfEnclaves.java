public class NumberOfEnclaves {
	public static int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public int numEnclaves(int[][] A) {
		if (A.length == 0 || A[0].length == 0) {
			return 0;
		}

		int count = 0;
		boolean[][] visited = new boolean[A.length][A[0].length];
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = 0; j < A[0].length - 1; j++) {
				if (A[i][j] == 1 && !visited[i][j]) {
					int[] v = dfs(A, i, j, visited);
					count += v[1] == 0 ? v[0] : 0;
				}
			}
		}

		return count;
	}

	public int[] dfs(int[][] A, int row, int col, boolean[][] visited) {
		int count = 1;
		int off = 0;
		visited[row][col] = true;
		for (int[] move : moves) {
			int nr = row + move[0];
			int nc = col + move[1];

			if (!validate(nr, nc, A)) {
				off = 1;
				continue;
			}
			if (!visited[nr][nc] && A[nr][nc] == 1) {
				int[] c = dfs(A, nr, nc, visited);
				count += c[1] == 0 ? c[0] : 0;
			}
		}
		return new int[] {count, off};
	}

	public boolean validate(int row, int col, int[][] A) {
		return row >= 0 && row < A.length && col >= 0 && col < A[0].length;
	}
}
