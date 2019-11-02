public class MinDeletionSize {
	public int minDeletionSize(String[] A) {
		int[] dp = new int[A[0].length()];
		int res = A[0].length() - 1;
		for (int i = 0; i < A[0].length(); i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (possible(A, i, j) && dp[i] < 1 + dp[j]) {
					dp[i] = 1 + dp[j];
				}
			}
			res = Math.min(res, A[0].length() - dp[i]);
		}
		return res;
	}

	private boolean possible(String[] A, int i, int j) {
		for (int k = 0; k < A.length; k++) {
			if (A[k].charAt(i) < A[k].charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
