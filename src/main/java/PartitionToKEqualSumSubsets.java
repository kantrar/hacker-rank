import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int target = Arrays.stream(nums).sum();
		if (target % k != 0) {
			return false;
		}

		int todo = target;
		target = target / k;

		Boolean[] memo = new Boolean[1 << nums.length];
		memo[(1 << nums.length) - 1] = true;
		return search(memo, 0, nums, target, todo);
	}

	public boolean search(Boolean[] memo, int used, int[] nums, int target, int todo) {
		if (memo[used] != null) {
			return memo[used];
		}

		memo[used] = false;
		int targ = todo % target == 0 ? target : todo % target;
		for (int i = 0; i < nums.length; i++) {
			if ((((used >> i) & 1) == 0) && nums[i] <= targ && search(memo, (used | 1 << i), nums, target, todo - nums[i])) {
				memo[used] = true;
				break;
			}
		}

		return memo[used];
	}
}
