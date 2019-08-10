public class LargestSumOfAverages {
	public double largestSumOfAverages(int[] A, int K) {
		double[][] dp = new double[A.length + 1][A.length + 1];
		double[] sum = new double[A.length + 1];

		for (int i = 0; i < A.length; i++) {
			sum[i + 1] = sum[i] + A[i];
		}

		for (int i = 0; i < K; i++) {
			for (int s = 0; s < A.length; s++) {
				for (int e = s + 1; e <= A.length; e++) {
					double current = (sum[e] - sum[s]) / (e - s) + dp[e][A.length];
					dp[s][A.length] = Math.max(dp[s][A.length], current);
				}
			}
		}

		return dp[0][A.length];
	}
}
