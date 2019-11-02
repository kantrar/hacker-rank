public class NthDigit {
	long[] TENS;

	public int findNthDigit(int n) {
		TENS = new long[10];
		TENS[0] = 1;
		for (int i = 1; i < 10; i++) {
			TENS[i] = 10 * TENS[i - 1];
		}
		int i = 1;
		long ans = 0;
		long last = 0;
		while (i < 11 && ans + i * 9 * TENS[i - 1] < n && ans + i * 9 * TENS[i - 1] > 0) {
			ans += i * 9 * TENS[i - 1];
			last += 9 * TENS[i - 1];
			i++;
		}

		long offset = n - ans;
		long number = last + (long) Math.ceil((double) offset / i);

		String s = String.valueOf(number);
		int pos = (int) ((offset - 1) % i);
		return Integer.parseInt(s.substring(pos, pos + 1));
	}
	//
	//	public int findNthDigit(int n) {
	//		// 1-9 -> 1 * 9 = 9 digits
	//		// 10-99 -> 2 * 90 = 180 digits
	//		// 100-999 -> 3 * 900 = 270 digits
	//		// 1000-9999 -> 4 * (9 * 10 ^ (4 - 1)) digits
	//		TENS = new int[9];
	//		TENS[0] = 1;
	//		for (int i = 1; i < 9; i++) {
	//			TENS[i] = 10 * TENS[i - 1];
	//		}
	//
	//		int min = 1;
	//		int max = Integer.MAX_VALUE;
	//
	//		while (min <= max) {
	//			int mid = min + (max - min) / 2;
	//			int value = count(mid);
	//			if (value >= n) {
	//				max = mid - 1;
	//			} else {
	//				min = mid + 1;
	//			}
	//		}
	//
	//		int pos = n - count(max) - 1;
	//		String str = String.valueOf(min);
	//		return Integer.parseInt(str.substring(pos, pos + 1));
	//	}
	//
	//	private int count(int num) {
	//		String str = String.valueOf(num);
	//		int digits = str.length();
	//		int i = 1;
	//		int ans = 0;
	//		int last = 0;
	//		while (i + 1 <= digits) {
	//			ans += i * 9 * TENS[i - 1];
	//			last += 9 * TENS[i - 1];
	//			i++;
	//		}
	//
	//		int offset = num - last;
	//		ans += offset * digits;
	//		return ans < 0 ? Integer.MAX_VALUE : ans;
	//	}
}
