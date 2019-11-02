package AlgoExpert;

import java.util.Arrays;

public class NumberOfWaysToMakeChange {
	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		Arrays.sort(denoms);
		int[][] dp = new int[n + 1][denoms.length + 1];
		Arrays.fill(dp[0], 1);
		for (int i = 0; i < denoms.length; i++) {
			for (int target = 1; target <= n; target++) {
				dp[target][i + 1] = (target - denoms[i] >= 0 ? dp[target - denoms[i]][i + 1] : 0) + dp[target][i];
			}
		}
		return dp[n][denoms.length];
	}
}
