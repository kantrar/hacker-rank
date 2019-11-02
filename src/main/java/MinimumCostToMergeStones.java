public class MinimumCostToMergeStones {
	int MAX = 900000;

	public int mergeStones(int[] stones, int K) {
		int[] sum = new int[stones.length + 1];
		for (int i = 0; i < stones.length; i++) {
			sum[i + 1] = sum[i] + stones[i];
		}

		Integer[][][] dp = new Integer[stones.length][stones.length][K + 1];
		int value = mergeStones(sum, K, 1, 0, stones.length - 1, dp);
		return value >= MAX ? -1 : value;
	}

	private int mergeStones(int[] sum, int piles, int targetPiles, int left, int right, Integer[][][] dp) {
		if (left == right) {
			return targetPiles == 1 ? 0 : MAX;
		}
		if (dp[left][right][targetPiles] != null) {
			return dp[left][right][targetPiles];
		}

		int cost = MAX;
		for (int i = left; i < right; i++) {
			if (targetPiles == 1) {
				cost = Math.min(cost,
						sum[right + 1] - sum[left] + mergeStones(sum, piles, 1, left, i, dp) + mergeStones(sum, piles, piles - 1,
								i + 1, right, dp));
			} else {
				cost = Math.min(cost,
						mergeStones(sum, piles, 1, left, i, dp) + mergeStones(sum, piles, targetPiles - 1, i + 1, right, dp));
			}
		}

		dp[left][right][targetPiles] = cost;
		return cost;
	}
}
