public class KthLargestElementInAnArray {
	// QuickSelect
	public int findKthLargest(int[] nums, int k) {
		return findKthLargest(nums, 0, nums.length - 1, k - 1);
	}

	public int findKthLargest(int[] nums, int left, int right, int k) {
		int idx = partition(nums, left, right);

		if (k == idx) {
			return nums[idx];
		} else if (k > idx) {
			return findKthLargest(nums, idx + 1, right, k);
		} else {
			return findKthLargest(nums, left, idx - 1, k);
		}
	}

	public int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int pivotIdx = left;
		for (int i = left; i <= right - 1; i++) {
			if (nums[i] > pivot) {
				swap(nums, i, pivotIdx);
				pivotIdx++;
			}
		}

		swap(nums, right, pivotIdx);

		return pivotIdx;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
