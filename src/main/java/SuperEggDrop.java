public class SuperEggDrop {
	public int superEggDrop(int K, int N) {
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
		}

		for (int k = 2; k <= K; k++) {
			int[] nextDp = new int[N + 1];
			int x = 1;
			for (int n = 1; n <= N; n++) {
				while (x < n && Math.max(dp[x - 1], nextDp[n - x]) > Math.max(dp[x], nextDp[n - x - 1])) {
					x++;
				}
				nextDp[n] = 1 + Math.max(dp[x - 1], nextDp[n - x]);
			}
			dp = nextDp;
		}
		return dp[N];
	}

	//	public int superEggDrop(int K, int N) {
	//		int binaryCount = (int) Math.floor(Math.log(N) / Math.log(2)) + 1;
	//		if (K >= binaryCount) {
	//			return binaryCount;
	//		}
	//		;
	//		int[][][] dp = new int[N + 1][N + 1][K + 1];
	//		return countDrop(1, N, K);
	//	}
	//
	//	private int countDrop(int low, int high, int k) {
	//		int l = low;
	//		int h = high;
	//		if (h <= l) {
	//			return Math.max(0, h - l + 1);
	//		}
	//		if (k == 1) {
	//			return h - l + 1;
	//		}
	//		while (l <= h) {
	//			int mid = l + (h - l) / 2;
	//			int dropLower = countDrop(l, mid - 1, k - 1) + 1;
	//			int dropHigher = countDrop(mid + 1, h, k) + 1;
	//			if (dropHigher < dropLower) {
	//				h = mid - 1;
	//			} else {
	//				l = mid + 1;
	//			}
	//		}
	//		return Math.min(Math.max(countDrop(low, h, k - 1) + 1, countDrop(h + 1, high, k) + 1),
	//				Math.max(countDrop(low, l, k - 1) + 1, countDrop(l + 1, high, k) + 1));
	//	}

	//	public int superEggDrop(int K, int N) {
	//		int binaryCount = (int) Math.floor(Math.log(N) / Math.log(2)) + 1;
	//		if (K >= binaryCount) {
	//			return binaryCount;
	//		}
	//		;
	//		int[][][] dp = new int[N + 1][N + 1][K + 1];
	//		return countDrop(1, N, K, dp);
	//	}
	//
	//	private int countDrop(int low, int high, int k, int[][][] dp) {
	//		if (high < low) {
	//			return 0;
	//		}
	//		if (k == 1) {
	//			return high - low + 1;
	//		}
	//		if (k >= high - low + 1) {
	//			return (int) Math.floor(Math.log(high - low + 1) / Math.log(2)) + 1;
	//		}
	//		if (dp[low][high][k] != 0) {
	//			return dp[low][high][k];
	//		}
	//
	//		int min = high - low + 1;
	//		for (int i = low; i <= high; i++) {
	//			int max = Math.max(countDrop(low, i - 1, k - 1, dp), countDrop(i + 1, high, k, dp));
	//			min = Math.min(min, max + 1);
	//		}
	//		dp[low][high][k] = min;
	//		return min;
	//	}
}
