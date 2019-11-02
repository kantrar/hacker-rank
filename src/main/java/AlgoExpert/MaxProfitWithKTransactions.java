package AlgoExpert;

public class MaxProfitWithKTransactions {
	public static int maxProfitWithKTransactions(int[] prices, int k) {
		int[][] dp = new int[k + 1][prices.length + 1];
		for (int i = 1; i <= k; i++) {
			for (int d = 1; d < prices.length; d++) {
				int prev = Integer.MIN_VALUE;
				for (int j = 0; j <= d; j++) {
					prev = Math.max(prev, -prices[j] + dp[i - 1][j]);
				}
				dp[i][d + 1] = Math.max(dp[i][d], prices[d] + (prev == Integer.MAX_VALUE ? 0 : prev));
			}
		}
		return dp[k][prices.length];
	}
}
