public class MinimumScoreTriangulationOfPolygon {
	public int minScoreTriangulation(int[] A) {
		int[][] dp = new int[A.length][A.length];
		for (int k = 2; k < A.length; k++) {
			for (int i = 0; i + k < A.length; i++) {
				int s = i + k;
				for (int j = i + 1; j < i + k; j++) {
					int t = j % A.length;
					int current = dp[i][t] + dp[t][s] + A[i] * A[t] * A[s];
					dp[i][s] = dp[i][s] == 0 ? current : Math.min(dp[i][s], current);
				}
			}
		}
		return dp[0][A.length - 1];
	}

}
