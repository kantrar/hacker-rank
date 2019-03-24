public class SherlockAndCost {
	static long cost(int[] B) {
		int[] low = new int[B.length];
		long[][] f = new long[B.length][2];
		for (int i = 0; i < B.length; i++) {
			low[i] = 1;
			f[i][0] = -1;
			f[i][1] = -1;
		}

		long first = getDiff(low, B, low[0], 0, f);
		long second = getDiff(low, B, B[0], 0, f);

		return Math.max(first, second);
	}

	static long getDiff(int[] low, int[] high, int firstElem, int pos, long[][] f) {
		if (pos + 1 >= low.length) {
			return 0L;
		}

		if (firstElem == high[pos] && f[pos][1] != -1) {
			return f[pos][1];
		}

		if (firstElem == low[pos] && f[pos][0] != -1) {
			return f[pos][0];
		}
		long diff = getDiff(low, high, high[pos + 1], pos + 1, f);
		long a1 = Math.abs(firstElem - high[pos + 1]) + diff;

		diff = getDiff(low, high, low[pos + 1], pos + 1, f);
		long a2 = Math.abs(firstElem - low[pos + 1]) + diff;

		long max = Math.max(a1, a2);
		if (firstElem == high[pos]) {
			f[pos][1] = max;
		}

		if (firstElem == low[pos]) {
			f[pos][0] = max;
		}

		return max;
	}
}
