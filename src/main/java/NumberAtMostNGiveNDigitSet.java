public class NumberAtMostNGiveNDigitSet {
	public int atMostNGivenDigitSet(String[] digits, int bound) {
		String boundStr = String.valueOf(bound);
		int[] dp = new int[boundStr.length() + 1];
		dp[boundStr.length()] = 1;
		for (int i = boundStr.length() - 1; i >= 0; i--) {
			int c = boundStr.charAt(i) - '0';
			for (String digit : digits) {
				int d = Integer.valueOf(digit);
				if (c > d) {
					dp[i] += Math.pow(digits.length, boundStr.length() - i - 1);
				} else if (c == d) {
					dp[i] += dp[i + 1];
				}
			}
		}

		for (int i = 1; i < boundStr.length(); i++) {
			dp[0] += Math.pow(digits.length, i);
		}
		return dp[0];
	}

}
