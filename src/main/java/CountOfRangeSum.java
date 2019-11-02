public class CountOfRangeSum {
	public int countRangeSum(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}
		return merge(sums, 0, sums.length - 1, lower, upper);
	}

	private int merge(long[] sums, int left, int right, int lower, int upper) {
		if (left >= right) {
			return 0;
		}
		int mid = left + (right - left) / 2;
		int count = merge(sums, left, mid, lower, upper) + merge(sums, mid + 1, right, lower, upper);

		int j = mid + 1;
		int k = mid + 1;
		long[] newSums = new long[sums.length];

		for (int i = left; i <= mid; i++) {
			while (j <= right && sums[j] - sums[i] < lower) {
				j++;
			}
			while (k <= right && sums[k] - sums[i] <= upper) {
				k++;
			}
			count += k - j;
		}

		j = mid + 1;
		int r = left;
		for (int i = left; i <= mid; i++) {
			while (j <= right && sums[j] < sums[i]) {
				newSums[r++] = sums[j++];
			}
			newSums[r++] = sums[i];
		}
		while (j <= right) {
			newSums[r++] = sums[j++];
		}

		for (int i = left; i <= right; i++) {
			sums[i] = newSums[i];
		}

		return count;
	}
}
