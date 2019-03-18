public class BinarySearch {

	private static int search2(int[] array, int value) {
		int left = 0;
		int right = array.length - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			if (array[mid] < value) {
				right = mid + 1;
			} else if (array[mid] > value) {
				left = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int search(int[] inputs, int value) {
		return binarySearch(inputs, 0, inputs.length, value);
	}

	private static int binarySearch(int[] inputs, int start, int end, int value) {
		int mid = (start + end) / 2;
		while (start < end) {
			if (inputs[mid] > value) {
				end = mid;
			} else if (inputs[mid] < value) {
				start = mid + 1;
			} else {
				if (mid == 0 || inputs[mid - 1] < value) {
					return mid;
				}
				end = mid;
			}
			mid = (start + end) / 2;
		}

		return -1;
	}
}
