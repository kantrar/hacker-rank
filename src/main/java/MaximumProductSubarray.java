public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		return findMaxProducts(nums, 0, nums.length);
	}

	public int findMaxProducts(int[] nums, int left, int right) {
		if (left == right - 1) {
			return nums[left];
		}

		int mid = (left + right) / 2;
		int leftProduct = findMaxProducts(nums, left, mid);
		int rightProduct = findMaxProducts(nums, mid, right);
		int midProduct = findCrossingProducts(nums, left, mid, right);

		return Math.max(midProduct, Math.max(leftProduct, rightProduct));
	}

	public int findCrossingProducts(int[] nums, int left, int mid, int right) {
		int maxPositiveLeftSum = nums[mid - 1] > 0 ? nums[mid - 1] : 0;
		int maxPositiveRightSum = nums[mid] > 0 ? nums[mid] : 0;
		int minNegativeLeftSum = nums[mid - 1] < 0 ? -nums[mid - 1] : 0;
		int minNegativeRightSum = nums[mid] < 0 ? -nums[mid] : 0;
		int product = 1;
		int negativeNumber = nums[mid - 1] < 0 ? 1 : 0;
		for (int i = mid - 2; i >= left; i--) {
			if (nums[i] == 0) {
				break;
			}

			if (nums[i] < 0) {
				negativeNumber++;
				if (negativeNumber % 2 == 0) {
					maxPositiveLeftSum = -minNegativeLeftSum * nums[i];
				} else {
					minNegativeLeftSum = -maxPositiveLeftSum * nums[i];
				}
			} else {
				if (negativeNumber % 2 == 0) {
					maxPositiveLeftSum *= nums[i];
				} else {
					minNegativeLeftSum *= nums[i];
				}
			}
		}

		negativeNumber = nums[mid] < 0 ? 1 : 0;
		for (int i = mid + 1; i < right; i++) {
			if (nums[i] == 0) {
				break;
			}

			if (nums[i] < 0) {
				negativeNumber++;
				if (negativeNumber % 2 == 0) {
					maxPositiveRightSum = -minNegativeRightSum * nums[i];
				} else {
					minNegativeRightSum = -maxPositiveRightSum * nums[i];
				}
			} else {
				if (negativeNumber % 2 == 0) {
					maxPositiveRightSum *= nums[i];
				} else {
					minNegativeRightSum *= nums[i];
				}
			}
		}

		return Math.max(maxPositiveLeftSum * maxPositiveRightSum, minNegativeLeftSum * minNegativeRightSum);
	}
}
