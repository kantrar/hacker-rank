import java.util.Arrays;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		Arrays.sort(nums);

		if ((S + sum) % 2 != 0) {
			return 0;
		}

		int target = (S + sum) / 2;

		int[][] dp = new int[nums.length][target + 1];
		dp[0][0] = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j <= target; j++) {
				if (i >= 1) {
					dp[i][j] += dp[i - 1][j];
				}

				if (j == nums[i] && i == 0) {
					dp[i][j]++;
				} else if (j >= nums[i] && i >= 1) {
					dp[i][j] += dp[i - 1][j - nums[i]];
				}
			}
		}

		return dp[nums.length - 1][target];
	}
}
