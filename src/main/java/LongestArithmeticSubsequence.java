import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

	public int longestArithSeqLength(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		Map<Integer, Integer>[] dp = new HashMap[A.length];
		int answer = 1;

		for (int i = 0; i < A.length; i++) {
			dp[i] = new HashMap<>();
		}

		for (int i = A.length - 1; i >= 0; i--) {
			dp[i].put(null, 1);
			for (int j = i + 1; j < A.length; j++) {
				int diff = A[j] - A[i];
				if (dp[j].containsKey(diff)) {
					int newValue = dp[j].get(diff) + 1;
					dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 0), newValue));

					answer = Math.max(answer, dp[i].get(diff));
				} else if (dp[j].containsKey(null)) {
					int newValue = 2;
					dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 0), newValue));

					answer = Math.max(answer, dp[i].get(diff));
				}
			}
		}

		return answer;
	}
}
