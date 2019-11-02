public class KthLargestElementInAnArray {

	// Quick select - iterative
	public int findKthLargest(int[] nums, int k) {
		int low = 0;
		int high = nums.length - 1;
		// we are trying place find the kth element [1-based] in the array after sorted
		k = nums.length - k;
		while (low <= high) {
			int idx = partition(nums, low, high);
			if (idx == k) {
				break;
			}
			if (idx > k) {
				high = idx - 1;
			} else {
				low = idx + 1;
			}
		}

		return nums[k];
	}

	private int partition(int[] nums, int low, int high) {
		int i = low + 1;
		int j = high;
		while (i < j) {
			while (i < j && nums[low] > nums[i]) {
				i++;
			}
			while (i < j && nums[low] <= nums[j]) {
				j--;
			}
			if (i >= j) {
				swap(nums, low,j  - 1);
				return j - 1;
			}
			swap(nums, i, j);
		}
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
