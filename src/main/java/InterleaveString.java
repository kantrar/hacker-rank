public class InterleaveString {
	public boolean isInterleave(String s1, String s2, String s3) {
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[s1.length()][s2.length()] = true;
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (!dp[i][j] && i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
					dp[i][j] = dp[i + 1][j];
				}

				if (!dp[i][j] && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
					dp[i][j] = dp[i][j + 1];
				}
			}
		}

		return dp[0][0];
	}

	public String getSubstring(String s, int pos) {
		if (s.length() == 0) {
			return "";
		}

		return s.substring(pos);
	}
}
