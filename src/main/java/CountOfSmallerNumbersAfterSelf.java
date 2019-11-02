import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		List<Integer> index = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			index.add(0, i);
			res.add(0);
		}
		countSmaller(nums, index, 1 << 31, res);

		return res;
	}

	private void countSmaller(int[] nums, List<Integer> index, int mask, List<Integer> res) {
		if (mask == 0 || index.isEmpty()) {
			return;
		}

		List<Integer> highGroup = new ArrayList<>();
		List<Integer> lowGroup = new ArrayList<>();

		// we need to introduce highBit to handle negative values
		// if no negative values -> we can compare by using mask instead of highBig
		int highBit = mask < 0 ? 0 : mask;
		for (int i = 0; i < index.size(); i++) {
			if ((nums[index.get(i)] & mask) == highBit) {
				res.set(index.get(i), res.get(index.get(i)) + lowGroup.size());
				highGroup.add(index.get(i));
			} else {
				lowGroup.add(index.get(i));
			}
		}
		countSmaller(nums, lowGroup, mask >>> 1, res);
		countSmaller(nums, highGroup, mask >>> 1, res);
	}

}
