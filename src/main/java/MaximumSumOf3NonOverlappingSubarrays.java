public class MaximumSumOf3NonOverlappingSubarrays {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int curSum = 0;
		int[][] dp = new int[4][nums.length + 1];
		int[][] idx = new int[4][nums.length + 1];
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < nums.length; j++) {
				curSum += nums[j];
				if (j >= k - 1) {
					if (dp[i][j + 1] < dp[i][j]) {
						dp[i][j + 1] = dp[i][j];
						idx[i][j + 1] = idx[i][j];
					}
					if (dp[i][j + 1] < dp[i - 1][j - k + 1] + curSum) {
						dp[i][j + 1] = curSum + dp[i - 1][j - k + 1];
						idx[i][j + 1] = j - k + 1;
					}
					curSum -= nums[j - k + 1];
				}
			}
		}

		int[] res = new int[3];
		res[2] = idx[3][nums.length];
		res[1] = idx[2][res[2]];
		res[0] = idx[1][res[1]];
		return res;
	}

}
