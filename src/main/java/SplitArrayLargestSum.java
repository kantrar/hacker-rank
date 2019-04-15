import java.util.Arrays;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		if (nums.length == 0) {
			return 0;
		}

		if (m > nums.length) {
			return Integer.MIN_VALUE;
		}

		int[][] dp = new int[nums.length + 1][51];
		for (int i = 0; i < nums.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		return findLargestSum(nums, 0, 0, m, dp);
	}

	public int findLargestSum(int[] nums, int pos, int accSum, int numberOfSubArray, int[][] dp) {
		if (pos >= nums.length) {
			if (numberOfSubArray == 1) {
				return accSum;
			} else {
				return Integer.MIN_VALUE;
			}
		}

		if (numberOfSubArray <= 0) {
			return Integer.MIN_VALUE;
		}

		// split here
		int sum1 = Integer.MIN_VALUE;
		// Splittable when the remaining element is greater or equal to the number of sub array
		if (nums.length - pos >= numberOfSubArray) {
			if (pos + 1 < nums.length && numberOfSubArray >= 0 && dp[pos + 1][numberOfSubArray - 1] != -1) {
				sum1 = dp[pos + 1][numberOfSubArray - 1];
			} else {
				sum1 = findLargestSum(nums, pos + 1, 0, numberOfSubArray - 1, dp);
				if (sum1 == Integer.MIN_VALUE) {
					sum1 = Integer.MAX_VALUE;
				} else {
					sum1 = Math.max(accSum + nums[pos], sum1);
					dp[pos][numberOfSubArray - 1] = sum1;
				}
			}
		}

		// not split here
		int sum2 = findLargestSum(nums, pos + 1, accSum + nums[pos], numberOfSubArray, dp);
		if (sum2 == Integer.MIN_VALUE) {
			sum2 = Integer.MAX_VALUE;
		}

		return Math.min(sum1, sum2);
	}

}
