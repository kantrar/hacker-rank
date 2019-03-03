public class BinarySearch {
	private static int search(int[] array, int value) {
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
}
