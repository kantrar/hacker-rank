public class CountingInversion {

	static long countInversions(int[] arr) {
		int[] temp = new int[arr.length];
		return mergeSort(arr, temp, 0, arr.length);
	}

	private static long mergeSort(int[] arr, int[] temp, int start, int end) {
		if (end - start <= 1) {
			return 0L;
		}

		long answer = 0;

		int mid = (start + end) / 2;
		answer += mergeSort(arr, temp, start, mid);
		answer += mergeSort(arr, temp, mid, end);

		int i = start;
		int j = mid;
		int idx = start;

		while (i < mid && j < end) {
			if (arr[i] <= arr[j]) {
				temp[idx++] = arr[i++];
			} else {
				answer += (mid - i);
				temp[idx++] = arr[j++];
			}
		}

		while (i < mid) {
			temp[idx++] = arr[i++];
		}

		while (j < end) {
			temp[idx++] = arr[j++];
		}

		for (int k = start; k < end; k++) {
			arr[k] = temp[k];
		}

		return answer;
	}
}
