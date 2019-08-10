import java.util.HashSet;
import java.util.Set;

public class BitwiseOrsOfSubarray {
	public int subarrayBitwiseORs(int[] A) {
		int[][] dp = new int[A.length][A.length];
		Set<Integer> seen = new HashSet<>();
		for (int len = 1; len <= A.length; len++) {
			for (int i = 0; i + len - 1 < A.length; i++) {
				if (len == 1) {
					dp[i][i] = A[i];
				} else {
					dp[i][i + len - 1] = dp[i][i + len - 2] | A[i + len - 1];
				}
				seen.add(dp[i][i + len - 1]);
			}
		}

		return seen.size();
	}
}
