public class IntegerBreak {
	public int integerBreak(int n) {
		if (n == 2) {
			return 1;
		}
		int max = 0;
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], j * dp[i - j]);
			}
			max = Math.max(max, dp[i]);
			dp[i] = Math.max(i, dp[i]);
		}
		return max;
	}
}
