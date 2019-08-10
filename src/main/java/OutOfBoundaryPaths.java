public class OutOfBoundaryPaths {
	private static int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static int MOD = 1_000_000_007;

	public int findPaths(int m, int n, int N, int row, int col) {
		int ans = 0;
		int[][][] dp = new int[m][n][N + 1];
		dp[row][col][0] = 1;
		for (int move = 1; move <= N; move++) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (i == 0) {
						ans = (ans + dp[i][j][move - 1]) % MOD;
					}
					if (j == 0) {
						ans = (ans + dp[i][j][move - 1]) % MOD;
					}

					if (i == m - 1) {
						ans = (ans + dp[i][j][move - 1]) % MOD;
					}

					if (j == n - 1) {
						ans = (ans + dp[i][j][move - 1]) % MOD;
					}

					for (int[] mv : moves) {
						int nr = i + mv[0];
						int nc = j + mv[1];

						if (validate(nr, nc, m, n)) {
							dp[i][j][move] = (dp[i][j][move] + dp[nr][nc][move - 1]) % MOD;
						}
					}
				}
			}
		}

		return ans;
	}

	public boolean validate(int row, int col, int maxRow, int maxCol) {
		return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
	}
}
