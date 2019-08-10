import java.util.Deque;
import java.util.LinkedList;

public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		Integer[] min = new Integer[nums.length];
		Deque<Integer> stack = new LinkedList<>();
		stack.push(0);
		for (int i = 1; i < nums.length; i++) {
			if (i - stack.peekFirst() > k) {
				stack.pollFirst();
			}
			Integer temp = null;
			while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
				temp = stack.pollLast();
			}
			min[i] = stack.isEmpty() ? temp : stack.peekFirst();
			stack.addLast(i);
		}

		Integer[] max = new Integer[nums.length];
		stack = new LinkedList<>();
		stack.push(0);
		for (int i = 1; i < nums.length; i++) {
			if (i - stack.peekFirst() > k) {
				stack.pollFirst();
			}
			Integer temp = null;
			while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
				temp = stack.pollLast();
			}
			max[i] = stack.isEmpty() ? temp : stack.peekFirst();
			stack.addLast(i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (min[i] != null && Math.abs(nums[i] - nums[min[i]]) <= t) {
				return true;
			}
			if (max[i] != null && Math.abs(nums[i] - nums[max[i]]) <= t) {
				return true;
			}
		}

		return false;
	}
}
