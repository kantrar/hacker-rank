import java.util.Arrays;

public class FindKthSmallestPairDistance {
	public int smallestDistancePair(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}

		Arrays.sort(nums);
		int min = 0;
		int max = nums[nums.length - 1] - nums[0];

		while (min <= max) {
			int mid = min + (max - min) / 2;
			int t = count(nums, mid);

			if (t < k) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		return min;
	}

	public int count(int[] nums, int value) {
		int res = 0;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			j = Math.max(j, i + 1);
			while (j < nums.length && nums[j] - nums[i] <= value) {
				j++;
			}
			res += j - i - 1;
		}

		return res;
	}
}
