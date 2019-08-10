import java.util.Arrays;

public class SumOfSubsequenceWidths {
	private static int MOD = 1_000_000_007;
	public int sumSubseqWidths(int[] A) {
		if (A.length <= 1) {
			return 0;
		}

		Arrays.sort(A);

		long[] pow = new long[20001];
		pow[0] = 1;
		for (int i = 1; i < 20001; i++) {
			pow[i] = (2 * pow[i - 1]) % MOD;
		}

		long ans = 0;
		for (int i = 0; i < A.length; i++) {
			ans += ((long) A[i] * (pow[i] - pow[A.length - i - 1])) % MOD;
		}

		return (int) ans;
	}

}
