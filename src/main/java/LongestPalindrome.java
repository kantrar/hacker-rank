public class LongestPalindrome {
	public String longestPalindrome(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
		}
		for (int len = 1; len < s.length(); len++) {
			for (int i = 0; i < s.length(); i++) {
				if (i + len >= s.length()) {
					break;
				}

				if (s.charAt(i) == s.charAt(i + len)) {
					if (i + 1 >= i + len - 1) {
						dp[i][i + len] = true;
						answer = s.substring(i, i + len + 1);
					} else {
						dp[i][i + len] = dp[i + 1][i + len - 1];
						if (dp[i][i + len]) {
							answer = s.substring(i, i + len + 1);
						}
					}
				}
			}
		}

		return answer;
	}
}
