public class MergeSort {
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length);
	}

	private static void sort(int[] arr, int start, int end) {
		if (end - start <= 1) {
			return;
		}

		int mid = (start + end) / 2;
		sort(arr, start, mid);
		sort(arr, mid, end);

		int[] newArr = new int[arr.length];
		int i = start;
		int j = mid;
		int idx = start;

		while (i < mid && j < end) {
			if (arr[i] <= arr[j]) {
				newArr[idx++] = arr[i++];
			} else {
				newArr[idx++] = arr[j++];
			}
		}

		while (i < mid) {
			newArr[idx++] = arr[i++];
		}

		while (j < end) {
			newArr[idx++] = arr[j++];
		}

		for (int i1 = start; i1 < end; i1++) {
			arr[i1] = newArr[i1];
		}
	}

	public static void sortDesc(int[] arr) {
		sortDesc(arr, 0, arr.length);
	}

	private static void sortDesc(int[] arr, int start, int end) {
		if (end - start <= 1) {
			return;
		}

		int[] newArr = new int[end - start];

		int mid = (start + end) / 2;
		sortDesc(arr, start, mid);
		sortDesc(arr, mid, end);

		int i = start;
		int j = mid;
		int idx = 0;
		while (i < mid && j < end) {
			if (arr[i] >= arr[j]) {
				newArr[idx++] = arr[i++];
			} else {
				newArr[idx++] = arr[j++];
			}
		}

		while (i < mid) {
			newArr[idx++] = arr[i++];
		}

		while (j < end) {
			newArr[idx++] = arr[j++];
		}

		for (int k = 0; k < end - start; k++) {
			arr[start + k] = newArr[k];
		}
	}
}
