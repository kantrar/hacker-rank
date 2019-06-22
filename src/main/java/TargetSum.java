import java.util.HashMap;
import java.util.Map;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int target) {
		Map<Integer, Integer> possibleSums = new HashMap<>();
		possibleSums.put(0, 1);

		for (int i = nums.length - 1; i >= 0; i--) {
			Map<Integer, Integer> nextPossibleSums = new HashMap<>();
			for (int s : possibleSums.keySet()) {
				int v1 = nextPossibleSums.getOrDefault(s + nums[i], 0) + 1 * possibleSums.get(s);
				nextPossibleSums.put(s + nums[i], v1);

				int v2 = nextPossibleSums.getOrDefault(s - nums[i], 0) + 1 * possibleSums.get(s);
				nextPossibleSums.put(s - nums[i], v2);
			}

			possibleSums = nextPossibleSums;
		}

		return possibleSums.getOrDefault(target, 0);
	}
}
