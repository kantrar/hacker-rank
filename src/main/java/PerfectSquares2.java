import java.util.Arrays;

public class PerfectSquares2 {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (j * j == i) {
					dp[i] = 1;
					continue;
				}
				if (dp[i] == -1) {
					dp[i] = dp[i - j * j] + dp[j * j];
				} else {
					dp[i] = Math.min(dp[i], dp[i - j * j] + dp[j * j]);
				}
			}
		}

		return dp[n];
	}
}
