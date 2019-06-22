public class LongestPalindromeSubsequence {

	// Incorrect in some cases
	public int longestPalindromeSubseq(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[][] dp = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}

		int answer = 1;
		for (int len = 2; len <= s.length(); len++) {
			for (int i = 0; i + len - 1 < s.length(); i++) {
				int rightIdx = i + len - 1;
				if (s.charAt(i) == s.charAt(rightIdx)) {
					if (i + 1 > rightIdx - 1) {
						dp[i][rightIdx] = 2;
					} else {
						dp[i][rightIdx] = Math.max(dp[i][rightIdx], dp[i + 1][rightIdx - 1] + 2);
					}

					if (dp[i][rightIdx] > 0) {
						answer = Math.max(answer, dp[i][rightIdx]);
					}
				} else {
					int temp = 1;
					for (int j = rightIdx - 1; j >= i + 1; j--) {
						if (s.charAt(i) == s.charAt(j)) {
							if (i + 1 > j - 1) {
								temp = Math.max(temp, 2);
							} else if (dp[i + 1][j - 1] != 0) {
								temp = Math.max(temp, dp[i + 1][j - 1] + 2);
							}
						}
					}

					for (int j = i + 1; j < rightIdx; j++) {
						if (s.charAt(j) == s.charAt(rightIdx)) {
							if (j + 1 > rightIdx - 1) {
								temp = Math.max(temp, 2);
							} else if (dp[j + 1][rightIdx - 1] != 0) {
								temp = Math.max(temp, dp[j + 1][rightIdx - 1] + 2);
							}
						}
					}

					dp[i][rightIdx] = temp;
					if (dp[i][rightIdx] > 0) {
						answer = Math.max(answer, dp[i][rightIdx]);
					}
				}
			}
		}

		return answer;
	}
}
