import java.util.Arrays;

public class PalindromeRemoval {
	public int minimumMoves(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		int[] next = new int[arr.length];
		Arrays.fill(next, -1);
		int[] temp = new int[21];
		Arrays.fill(temp, -1);

		for (int i = arr.length - 1; i >= 0; i--) {
			next[i] = temp[arr[i]];
			temp[arr[i]] = i;
		}

		return findMinimumMoves(arr, dp, next, 0, arr.length - 1);
	}

	private int findMinimumMoves(int[] arr, int[][] dp, int[] next, int left, int right) {
		if (right < left) {
			return 0;
		}
		int len = right - left + 1;
		if (len <= 1) {
			return len;
		}

		if (dp[left][right] != 0) {
			return dp[left][right];
		}

		int min = len;

		if (arr[left] == arr[right]) {
			if (left + 1 > right - 1) {
				min = 1;
			} else {
				min = Math.min(min, findMinimumMoves(arr, dp, next, left + 1, right - 1));
			}
		} else if (next[left] == -1) {
			min = Math.min(min, 1 + findMinimumMoves(arr, dp, next, left + 1, right));
		} else {
			for (int i = left; i < right; i++) {
				min = Math.min(min, findMinimumMoves(arr, dp, next, left, i) + findMinimumMoves(arr, dp, next, i + 1, right));
			}
		}

		dp[left][right] = min;
		return min;
	}
}
