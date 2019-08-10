public class DecreaseElementsToMakeArrayZigzag {
	public int movesToMakeZigzag(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}

		int m1 = 0;
		for (int i = 0; i < nums.length; i += 2) {
			int value =
					Math.min(i - 1 >= 0 ? nums[i - 1] : Integer.MAX_VALUE, i + 1 < nums.length ? nums[i + 1] : Integer.MAX_VALUE)
							- 1;
			m1 += nums[i] < value ? 0 : nums[i] - value;
		}

		int m2 = 0;
		for (int i = 1; i < nums.length; i += 2) {
			int value =
					Math.min(i - 1 >= 0 ? nums[i - 1] : Integer.MAX_VALUE, i + 1 < nums.length ? nums[i + 1] : Integer.MAX_VALUE)
							- 1;
			m2 += nums[i] < value ? 0 : nums[i] - value;
		}

		return Math.min(m1, m2);
	}

}
