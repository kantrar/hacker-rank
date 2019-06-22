import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence {
	public int longestArithSeqLength(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		Map<Integer, Integer>[] dp = new HashMap[A.length];
		for (int i = 0; i < A.length; i++) {
			dp[i] = new HashMap<>();
		}

		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result = Math.max(result, find(A, i, dp, null));
		}

		return result;
	}

	public int find(int[] A, int pos, Map<Integer, Integer>[] dp, Integer diff) {

		if (pos >= A.length) {
			return 0;
		}

		if (dp[pos].containsKey(diff)) {
			return dp[pos].get(diff);
		}

		int result = 0;
		for (int i = pos + 1; i < A.length; i++) {
			if ((diff == null || A[i] - A[pos] == diff) && !dp[pos].containsKey(A[i] - A[pos])) {
				result = Math.max(result, find(A, i, dp, A[i] - A[pos]));
			}
		}

		result++;
		dp[pos].put(diff, result);

		return result;
	}
}
