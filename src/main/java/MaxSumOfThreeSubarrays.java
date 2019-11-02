public class MaxSumOfThreeSubarrays {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] prefixSum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			prefixSum[i + 1] = prefixSum[i] + nums[i];
		}
		int[] leftSum = new int[nums.length];
		int[] leftMaxSum = new int[nums.length];
		for (int i = 0; i + k < prefixSum.length; i++) {
			leftSum[i] = prefixSum[i + k] - prefixSum[i];
			if (i >= 1 && leftSum[leftMaxSum[i - 1]] < leftSum[i]) {
				leftMaxSum[i] = i;
			} else if (i >= 1) {
				leftMaxSum[i] = leftMaxSum[i - 1];
			} else {
				leftMaxSum[i] = 0;
			}
		}

		int[] rightSum = new int[nums.length];
		int[] rightMaxSum = new int[nums.length];
		for (int i = prefixSum.length - k - 1; i >= 0; i--) {
			rightSum[i] = prefixSum[i + k] - prefixSum[i];
			if (i + 1 < nums.length && rightSum[rightMaxSum[i + 1]] < rightSum[i]) {
				rightMaxSum[i] = i;
			} else if (i + 1 < nums.length) {
				rightMaxSum[i] = rightMaxSum[i + 1];
			} else {
				rightMaxSum[i] = nums.length - 1;
			}
		}

		int max = 0;
		int[] res = new int[3];
		for (int i = k; i + 2 * k < nums.length; i++) {
			int midSum = prefixSum[i + k] - prefixSum[i];
			if (max < midSum + leftSum[leftMaxSum[i - k]] + rightSum[rightMaxSum[i + k]]) {
				res[0] = leftMaxSum[i - k];
				res[1] = i;
				res[2] = rightMaxSum[i + k];
			}
		}

		return res;
	}
}
