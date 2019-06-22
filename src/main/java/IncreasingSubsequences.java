import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> holder = new LinkedList<>();
		backtrack(nums, 0, holder, result);

		List<List<Integer>> answer = new ArrayList<>(result);
		return answer;
	}

	public void backtrack(int[] nums, int pos, List<Integer> holder, Set<List<Integer>> set) {
		if (holder.size() >= 2) {
			set.add(new LinkedList<>(holder));
		}

		for (int i = pos; i < nums.length; i++) {
			if (holder.isEmpty() || nums[i] >= holder.get(holder.size() - 1)) {
				holder.add(nums[i]);
				backtrack(nums, i + 1, holder, set);
				holder.remove(holder.size() - 1);
			}
		}
	}
}
