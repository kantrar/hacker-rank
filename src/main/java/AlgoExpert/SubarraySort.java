package AlgoExpert;

import java.util.Arrays;

public class SubarraySort {
	public static int[] subarraySort(int[] array) {
		int[] sorted = new int[array.length];
		Arrays.fill(sorted, Integer.MAX_VALUE);
		sorted[0] = array[0];
		int unsorted = Integer.MAX_VALUE;
		for (int i = 1; i < array.length; i++) {
			if (unsorted == Integer.MAX_VALUE && array[i] >= array[i - 1]) {
				sorted[i] = array[i];
			} else {
				unsorted = Math.min(unsorted, array[i]);
			}
		}

		if (unsorted == Integer.MAX_VALUE) {
			return new int[] {-1, -1};
		}

		int minIdx = Arrays.binarySearch(sorted, unsorted);
		minIdx = minIdx < 0 ? -(minIdx + 1) : minIdx;

		Arrays.fill(sorted, Integer.MIN_VALUE);
		sorted[array.length - 1] = array[array.length - 1];

		unsorted = Integer.MIN_VALUE;
		for (int i = array.length - 2; i >= 0; i--) {
			if (unsorted == Integer.MIN_VALUE && array[i] <= array[i + 1]) {
				sorted[i] = array[i];
			} else {
				unsorted = Math.max(unsorted, array[i]);
			}
		}

		int maxIdx = Arrays.binarySearch(sorted, unsorted);
		maxIdx = maxIdx < 0 ? -maxIdx - 2 : maxIdx;

		return new int[] {minIdx, maxIdx};
	}
}
