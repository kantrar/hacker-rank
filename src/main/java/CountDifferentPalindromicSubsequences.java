public class CountDifferentPalindromicSubsequences {
	public int countPalindromicSubsequences(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}

		int[] next = new int[s.length()];
		int[] prev = new int[s.length()];

		for (char c = 'a'; c <= 'b'; c++) {
			int cur = -1;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == c) {
					prev[i] = cur;
					cur = i;
				}
			}

			cur = s.length();
			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == c) {
					next[i] = cur;
					cur = i;
				}
			}
		}

		for (int len = 1; len < s.length(); len++) {
			for (int beg = 0, end = len; end < s.length(); beg++, end++) {
				if (s.charAt(beg) == s.charAt(end)) {
					dp[beg][end] = 2 * dp[beg + 1][end - 1];
					int left = next[beg];
					int right = prev[end];
					if (left > right) {
						dp[beg][end] += 2;
					} else if (left == right) {
						dp[beg][end]++;
					} else {
						dp[beg][end] -= dp[left + 1][right - 1];
					}
				} else {
					dp[beg][end] = dp[beg + 1][end] + dp[beg][end - 1] - dp[beg + 1][end - 1];
				}
			}
		}
		return dp[0][s.length() - 1];
	}
}
