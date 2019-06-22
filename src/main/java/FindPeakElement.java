public class FindPeakElement {
	public int findPeakElement(int[] nums) {

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (peak(nums, mid)) {
				return mid;
			} else if (rising(nums, mid)) {
				left = mid + 1;
			} else if (falling(nums, mid)) {
				right = mid - 1;
			} else {
				return -1;
			}
		}

		return -1;
	}

	private boolean peak(int[] nums, int mid) {
		boolean greaterThanRight = true;
		if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
			greaterThanRight = false;
		}

		boolean greaterThanLeft = true;
		if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
			greaterThanLeft = false;
		}

		return greaterThanRight && greaterThanLeft;
	}

	public boolean rising(int[] nums, int mid) {
		boolean lessThanRight = false;
		if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
			lessThanRight = true;
		}

		return lessThanRight;
	}

	public boolean falling(int[] nums, int mid) {
		boolean greaterThanRight = true;
		if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
			greaterThanRight = false;
		}

		return greaterThanRight;
	}

}
