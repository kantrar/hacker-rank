public class InterleavingStringII {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[] dp = new boolean[s2.length() + 1];
		dp[s2.length()] = true;
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i < s1.length()) {
					if (s1.charAt(i) == s3.charAt(i + j)) {
						dp[j] = dp[j];
					} else {
						dp[j] = false;
					}
				}

				if (!dp[j] && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
					dp[j] = dp[j + 1];
				}
			}
		}

		return dp[0];
	}
}
