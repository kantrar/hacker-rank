public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		long[][] dp = new long[nums.length + 1][m + 1];

		long[] sum = new long[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}

		for (int k = 1; k <= m; k++) {
			int idx = Math.max(0, k - 1);
			for (int i = k - 1; i < nums.length; i++) {
				dp[i + 1][k] = Integer.MAX_VALUE;

				if (k > 1) {
					while (idx < i && Math.max(dp[idx][k - 1], (sum[i + 1] - sum[idx])) > Math
							.max(dp[idx + 1][k - 1],(sum[i + 1] - sum[idx + 1]))) {
						idx++;
					}
				}
				dp[i + 1][k] = Math.max(dp[idx][k - 1], sum[i + 1] - sum[idx]);
			}
		}
		return (int) dp[nums.length][m];
	}

}
