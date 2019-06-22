import java.util.Arrays;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}

		int lowerBound = nums[nums.length - 1];
		int upperBound = nums[0];

		// The given nums is already sorted.
		if (lowerBound >= upperBound) {
			int idx = Arrays.binarySearch(nums, target);
			return idx >= 0 ? idx : -1;
		}

		if (target > lowerBound && target < upperBound) {
			return -1;
		}

		return find(nums, target, lowerBound, upperBound);
	}

	public int find(int[] nums, int target, int lowerBound, int upperBound) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target && target >= upperBound) {
				right = mid - 1;
			} else if (nums[mid] > target) {
				left = mid + 1;
			} else if (nums[mid] < target && target >= upperBound) {
				left = mid + 1;
			} else if (nums[mid] < target) {
				right = mid - 1;
			}
		}

		return -1;
	}
}
