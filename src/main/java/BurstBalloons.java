public class BurstBalloons {
	public int maxCoins(int[] nums) {
		if (nums.length == 0) return 0;

		int[][] dp = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i][i] = burst(nums, i, -1, nums.length);
		}

		for (int len = 1; len <= nums.length; len++) {
			for (int start = 0; start + len <= nums.length; start++) {
				for (int k = start; k < start + len; k++) {
					dp[start][start + len - 1] = Math.max(dp[start][start + len - 1], getDp(dp, start, k - 1) + burst(nums, k, start - 1, start + len) + getDp(dp, k + 1, start + len - 1));
				}
			}
		}

		return dp[0][nums.length - 1];
	}

	private int getDp(int[][] dp, int left, int right) {
		if (left > right) return 0;
		return dp[left][right];
	}

	private int burst(int[] nums, int mid, int left, int right) {
		int leftCoins = left >= 0 ? nums[left] : 1;
		int rightCoins = right < nums.length ? nums[right] : 1;
		return nums[mid] * leftCoins * rightCoins;
	}
}
