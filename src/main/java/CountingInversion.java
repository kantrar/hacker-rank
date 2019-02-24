public class CountingInversion {

	static long countInversions(int[] arr) {
		return mergeSort(arr, 0, arr.length);
	}

	private static long mergeSort(int[] arr, int start, int end) {
		if (end - start <= 1) {
			return 0L;
		}

		int answer = 0;
		int[] newArr = arr.clone();

		int mid = (start + end) / 2;
		answer += mergeSort(arr, start, mid);
		answer += mergeSort(arr, mid, end);

		int i = start;
		int j = mid;
		int idx = start;
		while (i < mid && j < end) {
			if (arr[i] <= arr[j]) {
				newArr[idx++] = arr[i];
				i++;
			}
			if (arr[i] > arr[j]) {
				answer += (mid - i);
				newArr[idx++] = arr[j];
				j++;
			}
		}

		while (i < mid) {
			newArr[idx++] = arr[i];
			i++;
		}

		while (j < end) {
			newArr[idx++] = arr[j];
			j++;
		}

		System.arraycopy(newArr, 0, arr, 0, newArr.length);

		return answer;
	}
}
