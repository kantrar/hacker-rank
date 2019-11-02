public class NextPermutation {
	public void nextPermutation(int[] nums) {
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				int j = i + 1;
				while (j < nums.length && nums[i] < nums[j]) {
					j++;
				}
				swap(nums, i, (j == nums.length - 1 && nums[j] > nums[i]) ? j : j - 1);
				reverse(nums, i + 1);
				return;
			}
		}
		reverse(nums, 0);
	}

	private void swap(int[] nums, int a, int b) {
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}

	private void reverse(int[] nums, int a) {
		int right = nums.length - 1;
		for (int i = a; i < right; i++) {
			swap(nums, i, right--);
		}
	}
}
