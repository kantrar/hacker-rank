public class DecibinaryNumbers {
	public static class Decibinary {
		long decibinaryValue;
		long decimalValue;
		int order;
		int latestPosBefore;

		public Decibinary(int o, long v, long dv, int p) {
			this.order = o;
			this.decibinaryValue = v;
			this.decimalValue = dv;
			this.latestPosBefore = p;
		}
	}

	// Complete the decibinaryNumbers function below.
	static long decibinaryNumbers(int max) {
		Decibinary[] f = new Decibinary[max + 1];

		f[0] = new Decibinary(0, 0, 0, 0);
		f[1] = new Decibinary(1, 0, 0, 1);
		f[2] = new Decibinary(2, 1, 1, 2);
		f[3] = new Decibinary(3, 2, 2, 3);
		f[4] = new Decibinary(4, 10, 2, 3);

		for (int i = 0; i <= max; i++) {
			if (f[i] == null) {
				calculateDecibinaryNumbers(i, f);
			}
		}

		return f[max].decibinaryValue;

	}

	static void calculateDecibinaryNumbers(int pos, Decibinary[] f) {
		if (pos >= f.length) {
			return;
		}

		if (f[pos] != null) {
			return;
		}

		long decimalValue = f[pos - 1].decimalValue;
		long newDecimalValue = decimalValue + 1;

		int latestPosBefore = f[pos - 1].latestPosBefore;

		int idx = pos;
		while (idx < pos + (pos - latestPosBefore) - 2) {
			long newDecibinaryValue = f[latestPosBefore + (idx - pos)].decibinaryValue + 1;
			f[idx] = new Decibinary(idx, newDecibinaryValue, newDecimalValue, pos);
			idx++;

			if (idx >= f.length) {
				return;
			}
		}

		long firstValue = f[latestPosBefore + (idx - pos)].decibinaryValue + 1;
		long secondValue = f[latestPosBefore + (idx + 1 - pos)].decibinaryValue + 1;

		idx = updateF(pos, f, newDecimalValue, idx, firstValue);
		updateF(pos, f, newDecimalValue, idx, secondValue);
	}

	private static int updateF(int pos, Decibinary[] f, long newDecimalValue, int idx, long secondValue) {
		int factor = 1;
		while (idx < f.length && (secondValue % (factor * 10)) / factor == 2) {
			f[idx] = new Decibinary(idx, secondValue, newDecimalValue, pos);
			idx++;

			secondValue = secondValue - 2 * factor + 10 * factor;
			factor *= 10;
		}

		if (idx >= f.length) {
			return idx;
		}

		f[idx] = new Decibinary(idx, secondValue, newDecimalValue, pos);
		idx++;

		return idx;
	}

}
