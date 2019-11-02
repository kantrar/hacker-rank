public class LongestValidParenthesis {
	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length() + 1];
		dp[0] = 0;
		int res = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				dp[i + 1] = 0;
			} else {
				if (s.charAt(i - 1) == '(') {
					dp[i + 1] = dp[i - 1] + 2;
				} else {
					int pair = i - 2 - dp[i - 1];
					if (pair >= 1 && s.charAt(pair) == '(' && s.charAt(pair - 1) == '(') {
						dp[i + 1] = dp[i - 1] + 4 + dp[pair - 1];
					}
				}
			}
			res = Math.max(res, dp[i + 1]);
		}
		return res;
	}
}
