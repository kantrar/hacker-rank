import java.util.Arrays;

public class MinimizeSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int[] sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}

		if (sum[nums.length] < s) {
			return 0;
		}
		int answer = nums.length;
		for (int i = nums.length - 1; i >= 0; i--) {
			int target = sum[i + 1] - s;
			if (target < 0) {
				break;
			}
			int idx = Arrays.binarySearch(sum, target);
			idx = idx < 0 ? -(idx + 1) - 1 : idx;

			answer = Math.min(answer, i - idx + 1);
		}

		return answer;
	}
}
