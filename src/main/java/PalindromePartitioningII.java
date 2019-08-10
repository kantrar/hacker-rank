public class PalindromePartitioningII {
	public int minCut(String s) {
		if (s.length() == 0) {
			return 0;
		}
		// aacbca
		boolean[][] dp = new boolean[s.length()][s.length()];
		findPalindrome(dp, s);

		Integer[] memo = new Integer[s.length()];
		return findCut(dp, 0, s, memo) - 1;
	}

	public int findCut(boolean[][] dp, int pos, String s, Integer[] memo) {
		if (pos >= s.length()) {
			return 0;
		}
		if (memo[pos] != null) {
			return memo[pos];
		}
		int min = s.length();
		for (int i = pos; i < s.length(); i++) {
			if (dp[pos][i]) {
				min = Math.min(min, findCut(dp, i + 1, s, memo) + 1);
			}
		}

		memo[pos] = min;
		return min;
	}

	public void findPalindrome(boolean[][] dp, String s) {
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
		}

		for (int len = 1; len <= s.length(); len++) {
			for (int j = 0; j + len - 1 < s.length(); j++) {
				if (s.charAt(j) == s.charAt(j + len - 1)) {
					dp[j][j + len - 1] = j + 1 > j + len - 2 ? true : dp[j + 1][j + len - 2];
				} else {
					dp[j][j + len - 1] = false;
				}
			}
		}
	}
}
