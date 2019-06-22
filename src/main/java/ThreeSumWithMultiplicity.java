public class ThreeSumWithMultiplicity {
	public int threeSumMulti(int[] A, int target) {
		int n = A.length, M = (int) 1e9 + 7;
		int[][][] dp = new int[n + 1][target + 1][4];
		for (int i = 0; i <= n; i++) {
			dp[i][0][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= target; j++) {
				for (int k = 1; k <= 3; k++) {
					dp[i + 1][j][k] = dp[i][j][k];
					dp[i + 1][j][k] %= M;
					if (j >= A[i]) {
						dp[i + 1][j][k] += dp[i][j - A[i]][k - 1];
						dp[i + 1][j][k] %= M;
					}
				}
			}
		}
		return dp[n][target][3];
	}

}
