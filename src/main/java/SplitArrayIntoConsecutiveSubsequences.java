import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SplitArrayIntoConsecutiveSubsequences {
	public boolean isPossible(int[] nums) {

		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		List<Integer> open = new ArrayList<>();
		int lastKey = 0;
		for (int key : map.keySet()) {
			int currentCount = map.getOrDefault(key, 0);
			int prevCount = map.getOrDefault(key - 1, 0);
			if (prevCount == 0) {
				while (!open.isEmpty()) {
					int p = open.remove(0);
					if (lastKey + 1 - p + 1 <= 3) {
						return false;
					}
				}
			}
			if (currentCount > prevCount) {
				for (int j = 0; j < currentCount - prevCount; j++) {
					open.add(key);
				}
			} else if (currentCount < prevCount) {
				for (int j = 0; j < prevCount - currentCount; j++) {
					int p = open.remove(0);
					if (key - p + 1 <= 3) {
						return false;
					}
				}
			}
			lastKey = key;
		}

		int prevCount = map.getOrDefault(lastKey, 0);
		for (int j = 0; j < prevCount; j++) {
			int p = open.remove(0);
			if (lastKey - p + 1 < 3) {
				return false;
			}
		}

		return open.isEmpty() ? true : false;
	}
}
