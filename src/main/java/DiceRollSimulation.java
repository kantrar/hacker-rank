public class DiceRollSimulation {
	int MOD = 1_000_000_007;

	public int dieSimulator(int n, int[] rollMax) {
		int[][] dp = new int[n + 1][rollMax.length];
		int[] totalDp = new int[n + 1];

		totalDp[0] = 1;
		for (int i = 0; i < rollMax.length; i++) {
			dp[1][i] = 1;
			totalDp[1]++;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < rollMax.length; j++) {
				int totalEndingWithCur = 0;
				for (int k = 0; k < rollMax[j] && i - k - 1 >= 0; k++) {
					totalEndingWithCur = (totalDp[i - k - 1] - dp[i - k - 1][j] + MOD);
					totalEndingWithCur = totalEndingWithCur % MOD;
				}
				dp[i][j] = totalEndingWithCur;
				totalDp[i] = (totalDp[i] + dp[i][j]) % MOD;
			}
		}
		return totalDp[n];
	}

}
