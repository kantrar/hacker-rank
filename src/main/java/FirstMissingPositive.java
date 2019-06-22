public class FirstMissingPositive {
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				nums[i] = 0;
			}
		}

		int i = 0;
		while (i < nums.length) {
			if (nums[i] == i + 1) {
				nums[i] = -nums[i];
				i++;
				continue;
			}

			while (nums[i] > 0 && nums[i] <= nums.length) {
				int idx = nums[i] - 1;
				swap(nums, i, nums[i] - 1);
				nums[idx] = -nums[idx];
			}

			i++;
		}

		for (i = 0; i < nums.length; i++) {
			if (-nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;
	}
}
