public class MaximumSumOf3NonOverlappingSubarrays {
	public static int max = 0;

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		max = 0;

		int[] sum = new int[nums.length - k + 1];

		for (int i = 0; i < k; i++) {
			sum[0] += nums[i];
		}

		for (int i = 1; i <= nums.length - k; i++) {
			sum[i] = sum[i - 1] + nums[k + i - 1] - nums[i - 1];
		}

		int[][][] dp = new int[sum.length][3][4];

		for (int m = 0; m < 3; m++) {
			if (m == 0) {
				dp[sum.length - 1][m][m] = sum.length - 1;
				dp[sum.length - 1][m][3] = sum[sum.length - 1];
			} else {
				dp[sum.length - 1 - m * k][m] = dp[sum.length - 1 - (m - 1) * k][m - 1];
				dp[sum.length - 1 - m * k][m][m] = sum.length - 1 - m * k;
				dp[sum.length - 1 - m * k][m][3] = sum[sum.length - 1 - m * k] + dp[sum.length - 1 - (m - 1) * k][m - 1][3];
			}
			for (int i = sum.length - 2 - m * k; i >= 0; i--) {
				if (m == 0) {
					if (sum[i] >= sum[dp[i + 1][m][m]]) {
						dp[i][m][m] = i;
						dp[i][m][3] = sum[i];
					} else {
						dp[i][m][m] = i + 1;
						dp[i][m][3] = sum[i + 1];
					}
				} else {
					if (sum[i] + dp[i + k][m - 1][3] >= dp[i + 1][m][3]) {
						System.arraycopy(dp[i + k][m - 1], 0, dp[i][m], 0, 4);
						dp[i][m][m] = i;
						dp[i][m][3] = sum[i] + dp[i + k][m - 1][3];
					} else {
						System.arraycopy(dp[i + 1][m], 0, dp[i][m], 0, 4);
					}
				}
			}
		}

		int[] answer = new int[3];
		for (int i = 0; i < 3; i++) {
			answer[i] = dp[0][2][3 - i - 1];
		}
		return answer;
	}

}
