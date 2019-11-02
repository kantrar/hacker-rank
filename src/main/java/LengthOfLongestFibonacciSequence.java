import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSequence {
	public int lenLongestFibSubseq(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], i);
		}

		int longest = 0;
		int[][] dp = new int[A.length][A.length];

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int prev = A[j] - A[i];
				if (i == 0) {
					dp[i][j] = 2;
				} else if (map.containsKey(prev) && map.get(prev) < i) {
					dp[i][j] = Math.max(dp[i][j], dp[map.get(prev)][i] + 1);
					longest = Math.max(longest, dp[i][j]);
				} else {
					dp[i][j] = 2;
				}
			}
		}

		return longest;
	}
}
