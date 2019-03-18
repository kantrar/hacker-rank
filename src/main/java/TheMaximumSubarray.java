public class TheMaximumSubarray {
	static long[] maxSubarray(long[] arr) {
		long maxValue = Long.MIN_VALUE;
		int pos = 0;

		while (pos < arr.length && arr[pos] <= 0) {
			maxValue = Math.max(maxValue, arr[pos]);
			pos++;
		}

		if (pos == arr.length) {
			return new long[] {maxValue, maxValue};
		}

		long[] maxSubarray = maxSubarray(arr, Integer.MIN_VALUE, pos);
		long maxSubsequence = maxSubsequence(arr, pos);

		return new long[] {maxSubarray[1], maxSubsequence};
	}

	static long maxSubsequence(long[] arr, int pos) {
		if (pos == arr.length - 1) {
			return arr[pos];
		}

		long result = maxSubsequence(arr, pos + 1);

		if (result > 0 && arr[pos] >= 0) {
			return arr[pos] + result;
		} else {
			if (arr[pos] > result) {
				return arr[pos];
			} else {
				return result;
			}
		}
	}

	static long[] maxSubarray(long[] arr, int max, int pos) {
		if (pos == arr.length - 1) {
			return new long[] {arr[pos], arr[pos]};
		}

		long[] result = maxSubarray(arr, max, pos + 1);

		long newResult = arr[pos] + result[0];
		if (newResult > 0) {
			if (arr[pos] > 0 && newResult > result[1]) {
				return new long[] {newResult, newResult};
			} else {
				return new long[] {newResult, result[1]};
			}
		}

		return new long[] {arr[pos] < 0 ? 0 : arr[pos], arr[pos] > result[1] ? arr[pos] : result[1]};
	}
}
