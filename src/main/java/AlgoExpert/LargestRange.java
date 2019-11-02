package AlgoExpert;

public class LargestRange {
	public static int[] largestRange(int[] array) {
		if (array == null || array.length == 0) {
			return new int[0];
		}
		int[] res = new int[] {array[0], array[0]};
		mergeSort(array, 0, array.length - 1, res);
		return res;
	}

	private static void mergeSort(int[] array, int left, int right, int[] res) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid, res);
		mergeSort(array, mid + 1, right, res);
		merge(array, left, mid, right, res);
	}

	private static void merge(int[] array, int left, int mid, int right, int[] res) {
		int j = mid + 1;
		int[] newArray = new int[right - left + 1];
		int cur = 0;
		int[] longest = new int[] {array[left], array[left]};
		int[] current = new int[] {array[left], array[left]};
		for (int i = left; i <= mid; i++) {
			while (j <= right && array[j] < array[i]) {
				newArray[cur] = array[j];
				current = updateCurrent(array, right, j, newArray, cur, current);
				longest = updateLongest(longest, current);
				j++;
				cur++;
			}
			newArray[cur] = array[i];
			current = updateCurrent(array, mid, i, newArray, cur, current);
			longest = updateLongest(longest, current);
			cur++;
		}
		while (j <= right) {
			newArray[cur] = array[j];
			current = updateCurrent(array, right, j, newArray, cur, current);
			longest = updateLongest(longest, current);
			j++;
			cur++;
		}

		for (int i = left; i <= right; i++) {
			array[i] = newArray[i - left];
		}

		if (res[1] - res[0] < longest[1] - longest[0]) {
			res[0] = longest[0];
			res[1] = longest[1];
		}
	}

	private static int[] updateLongest(int[] longest, int[] current) {
		if (longest[1] - longest[0] < current[1] - current[0]) {
			longest = current;
		}
		return longest;
	}

	private static int[] updateCurrent(int[] array, int right, int j, int[] newArray, int cur, int[] current) {
		if (cur < newArray.length && cur > 0 && (newArray[cur] == newArray[cur - 1] + 1 || newArray[cur] == newArray[cur - 1])) {
			current[1] = newArray[cur];
		} else if (j <= right) {
			current = new int[] {array[j], array[j]};
		}
		return current;
	}
}
