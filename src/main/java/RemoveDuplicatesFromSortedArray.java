public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int idx = 0;
		int i = 0;
		while (i < nums.length) {
			i = findLast(nums, nums[i], i, nums.length - 1);
			swap(nums, i, idx);
			idx++;
			i++;
		}

		return idx;
	}

	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public int findLast(int[] nums, int target, int left, int right) {
		int mid = left + (right - left) / 2;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target && (mid == right || nums[mid] < nums[mid + 1])) {
				return mid;
			}
			if (nums[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return mid;
	}
}
