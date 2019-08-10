public class GuessNumberHigherOrLowerII {
	public int getMoneyAmount(int n) {
		return guess(1, n);
	}

	public int guess(int left, int right) {
		if (left > right) {
			return 0;
		}
		if (left == right) {
			return left;
		}

		if (left + 1 == right) {
			return left;
		}

		if (left + 2 == right) {
			return left + 1;
		}

		int max;
		int ans = Integer.MAX_VALUE;
		for (int i = left; i <= right; i++) {
			max = Math.max(guess(left, i - 1), guess(i + 1, right));
			ans = Math.min(ans, i + max);
		}

		return ans;
	}
}
