import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int target = Arrays.stream(nums).sum();

		if (target % 2 != 0) {
			return false;
		}

		target = target / 2;

		List<Integer> sums = Arrays.asList(0);
		for (int i = 0; i < nums.length; i++) {
			List<Integer> newSums = new ArrayList<>();

			for (int j = 0; j < sums.size(); j++) {
				int value = nums[i] + sums.get(j);
				if (value == target) {
					return true;
				} else if (value < target) {
					newSums.add(value);
				}

				if (sums.get(j) < target) {
					newSums.add(sums.get(j));
				}
			}

			sums = newSums;
		}
		return false;
	}
}
