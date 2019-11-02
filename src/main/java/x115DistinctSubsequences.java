import java.util.Arrays;

public class x115DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int[] dp = new int[s.length() + 1];
		Arrays.fill(dp, 1);
		for (int i = t.length() - 1; i >= 0; i--) {
			int[] nextDp = new int[s.length() + 1];
			for (int j = s.length() - 1; j >= 0; j--) {
				if (t.charAt(i) == s.charAt(j)) {
					nextDp[j] = nextDp[j + 1] + dp[j + 1];
				} else {
					nextDp[j] = nextDp[j + 1];
				}
			}
			dp = nextDp;
		}
		return dp[0];
	}
}
