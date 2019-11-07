public class CountNumberOfNiceSubarrays {
	public int numberOfSubarrays(int[] nums, int k) {
		int left = 0;
		int right = 0;
		int odd = 0;
		int res = 0;

		while (right < nums.length) {
			int before = 0;
			int after = 1;

			while (right < nums.length && odd < k) {
				if ((nums[right++] % 2) == 1) odd++;
			}
			while (right < nums.length && (nums[right] % 2) == 0) {
				right++;
				after++;
			}
			while (odd == k) {
				before++;
				if (nums[left++] % 2 == 1) odd--;
			}
			res += before * after;
		}
		return res;
	}
}
