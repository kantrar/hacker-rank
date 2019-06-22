public class PartitionArrayForMaxSum {
	public int maxSumAfterPartitioning(int[] A, int K) {

		if (A.length <= K) {
			int max = 0;
			for (int i = 0; i < A.length; i++) {
				max = Math.max(max, A[i]);
			}

			return max * A.length;
		}
		int[] dp = new int[A.length];
		for (int i = A.length - 1; i >= 0; i--) {
			int currentMax = A[i];
			dp[i] = currentMax + get(dp, i + 1);
			for (int j = 1; j < K && i + j < A.length; j++) {
				currentMax = Math.max(currentMax, A[i + j]);
				dp[i] = Math.max(dp[i], currentMax * (j + 1) + get(dp, i + j + 1));
			}
		}

		return dp[0];
	}

	public int get(int[] input, int pos) {
		if (pos >= input.length) {
			return 0;
		}

		return input[pos];
	}

}
