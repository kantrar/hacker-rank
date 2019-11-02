import java.util.Arrays;

public class DistinctSubsequencesII
{
	int MOD = 1_000_000_007;
	public int distinctSubseqII(String S) {
		int[] pos = new int[128];
		Arrays.fill(pos, -1);

		int[] next = new int[S.length()];
		Arrays.fill(next, -1);
		for (int i = S.length() - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (pos[c] != -1) {
				next[i] = pos[c];
			}
			pos[c] = i;
		}

		int[] dp = new int[S.length() + 1];
		dp[S.length()] = 1;

		for (int i = S.length() - 1; i >= 0; i--) {
			dp[i] = 2 * dp[i + 1];
			if (next[i] != -1) {
				dp[i] -= dp[next[i]];
			}
			dp[i] %= MOD;
		}
		return dp[0] - 1;
	}
}
