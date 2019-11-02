public class ReversePairs {
	public int reversePairs(int[] nums) {
		int[] res = new int[1];
		int[] index = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			index[i] = i;
		}
		merge(nums, index, 0, nums.length - 1, res);

		return res[0];
	}

	private int[] merge(int[] nums, int[] index, int left, int right, int[] res) {
		if (left >= right) return index;

		int mid = left + (right - left) / 2;
		index = merge(nums, index, left, mid, res);
		index = merge(nums, index, mid + 1, right, res);

		int[] newIndex = index.clone();
		int r = mid + 1;
		for (int l = left; l <= mid; l++) {
			while (r <= right && nums[index[l]] > 2L * nums[index[r]]) {
				r++;
			}

			res[0] += (r - mid - 1);
		}
		r = mid + 1;
		int cur = left;
		for (int l = left; l <= mid; l++) {
			while (r <= right && nums[index[l]] > nums[index[r]]) {
				newIndex[cur++] = index[r++];
			}
			newIndex[cur++] = index[l];
		}

		while (r <= right) {
			newIndex[cur++] = index[r++];
		}
		return newIndex;
	}
}
