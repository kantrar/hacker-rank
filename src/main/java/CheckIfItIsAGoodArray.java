import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfItIsAGoodArray {
	public boolean isGoodArray(int[] nums) {
		Arrays.sort(nums);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			boolean add = true;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					add = false;
					break;
				}
			}
			if (add) set.add(nums[i]);
		}

		if (set.contains(1)) return true;
		if (set.size() == 1) return false;

		Set<Integer> diff = new HashSet<>();
		for (int a : set) {
			for (int b : set) {
				int d = b > a ? b - a : a - b;
				if (d == 0) continue;
				diff.add(d);
			}
		}
		if (diff.contains(1)) return true;
		for (int d: diff) {
			boolean all = true;
			for (int a : set) {
				if (a % d != 0) all = false;
			}
			if (all) return false;
		}

		return true;
	}
}
