public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		n = n > 10 ? 10 : n;

		int digit = 10;

		int ans = 0;
		int t = 1;
		for (int i = 1; i <= n; i++) {
			t *= (digit - i);
		}

		ans += t;

		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return ans + 1;
		}
		ans += 10;

		for (int i = 2; i <= n; i++) {
			t = (i - 1) * (digit - 1);
			for (int j = 1; j < n - 1; j++) {
				t *= (digit - (i - 2) - j);
			}
			ans += t;
		}

		return ans;
	}
}
