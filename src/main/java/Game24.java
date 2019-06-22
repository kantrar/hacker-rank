import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game24 {

	// Not works as the order is not necessarily preserved.
	public boolean judgePoint24(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				for (int k = 0; k < nums.length; k++) {
					for (int l = 0; l < nums.length; l++) {
						if (i == j || i == k || i == l || j == k || j == l || k == l) {
							continue;
						}

						int[] temp = new int[] {nums[i], nums[j], nums[k], nums[l]};

						Set<Integer> candidates = getPossibleValues(temp, 0, nums.length);
						if (candidates.contains(24)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	// right exclusive
	public Set<Integer> getPossibleValues(int[] nums, int left, int right) {
		if (left >= right) {
			return new HashSet<>();
		}

		if (left == right - 1) {
			return new HashSet<>(Arrays.asList(nums[left]));
		}

		int mid = (left + right) / 2;
		Set<Integer> oneHalf = getPossibleValues(nums, left, mid);
		Set<Integer> theOtherHalf = getPossibleValues(nums, mid, right);

		Set<Integer> result = new HashSet<>();

		for (int first : oneHalf) {
			for (int second : theOtherHalf) {
				result.add(first + second);
				result.add(first - second);
				result.add(first * second);
				if (second != 0) {
					result.add(first / second);
				}
			}
		}

		return result;
	}
}
