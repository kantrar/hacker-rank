import java.util.Arrays;

public class MatchsticksToSquare {
	public boolean makesquare(int[] nums) {
		int target = Arrays.stream(nums).sum();

		if (target % 4 != 0) {
			return false;
		}

		target = target / 4;

		int[] sum = new int[4];
		return findTarget(nums, target, 0, sum);
	}

	public boolean findTarget(int[] nums, int target, int pos, int[] sum) {
		if (pos >= nums.length) {
			for (int i = 0; i < sum.length; i++) {
				if (sum[i] != target) {
					return false;
				}
			}

			return true;
		}

		for (int i = 0; i < 4; i++) {
			if (putIntoBucketAndFind(nums, target, pos, sum, i)) {
				return true;
			}
		}

		return false;
	}

	private boolean putIntoBucketAndFind(int[] nums, int target, int pos, int[] sum, int i2) {
		sum[i2] += nums[pos];
		if (findTarget(nums, target, pos + 1, sum)) {
			return true;
		}
		sum[i2] -= nums[pos];

		return false;
	}
}
