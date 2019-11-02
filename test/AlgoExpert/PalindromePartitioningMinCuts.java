package AlgoExpert;

public class PalindromePartitioningMinCuts
{
	public static int palindromePartitioningMinCuts(String str) {
		int[] dp = new int[str.length() + 1];
		boolean[][] pair = new boolean[str.length()][str.length()];

		for (int len = 1; len <= str.length(); len++) {
			for (int i = 0; i + len <= str.length(); i++) {
				if (str.charAt(i) == str.charAt(i + len -  1) &&  (len < 3 || pair[i + 1][i + len - 2])) {
					pair[i][i + len - 1] = true;
				}
			}
		}


		for (int i = 0; i < str.length(); i++) {
			dp[i + 1] = i + 1;
			for (int j = 0; j <= i; j++) {
				if (pair[j][i]) {
					dp[i + 1] = Math.min(dp[i + 1], 1 + dp[j]);
				}
			}
		}
		return dp[str.length()] - 1;
	}
}
