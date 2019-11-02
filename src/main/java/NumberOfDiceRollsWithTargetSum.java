

public class NumberOfDiceRollsWithTargetSum {

	public static final int MOD = 1_000_000_007;

	public int numRollsToTarget(int d, int f, int target) {
		int[][] dp = new int[d][Math.max(f + 1, target + 1)];

		for (int i = 1; i <= f; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < d; i++) {
			for (int j = 0; j <= target; j++) {
				for (int k = 1; k <= f; k++) {
					dp[i][j] += j - k >= 0 ? (dp[i - 1][j - k] % MOD) : 0;
					dp[i][j] = dp[i][j] % MOD;
				}
			}
		}

		return dp[d - 1][target];
	}
}
