public class InterleaveString {
	public boolean isInterleave(String s1, String s2, String s3) {
		boolean[][] dp = new boolean[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			boolean[][] nextDp = new boolean[s1.length()][s2.length()];
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s3.charAt(i + j) && (i == 0 || dp[i - 1][j])) {
					nextDp[i][j] = true;
				} else if (s2.charAt(j) == s3.charAt(i + j) && (j == 0 || dp[i][j - 1])) {
					nextDp[i][j] = j - 1 >= 0 ? dp[i][j - 1] : true;
				} else {
					nextDp[i][j] = false;
				}
			}
			dp = nextDp;
		}

		return dp[s1.length() - 1][s2.length() - 1];
	}
}
